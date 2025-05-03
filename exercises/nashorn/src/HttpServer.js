// TODO 1: 
// Define some JavaScript variables to represent all the Java types needed in this app.



// Define some handy constants.
var PORT = 9000;
var CRLF = "\r\n";
var FILE_NOT_FOUND_PAGE = 
	"<html>" +
    "<head><title>404 File Not Found</title></head>" + 
    "<body style='font-family:Calibri'><h1>404</h1>File not found</p></body>" + 
	"</html>";


// ---------------------------------------------------------------------------------------------
// Start of the "real" code 
// ---------------------------------------------------------------------------------------------

// TODO 2: 
// Create a Java ServerSocket object, listening on a particular PORT.	


log("Server listening on port " + PORT);

// Loop forever.
while (true) {

	// TODO 3: 
	// Accept incoming requests on the server socket.

    
    try {
	
		// TODO 4: 
		// Create a new Thread object. In the constructor, pass in a JavaScript function to run in the separate thread. 
		// In the function, call handleHttpRequest to handle the incoming HTTP request on the socket. 

        
		// TODO 5:
		// Start the thread.
		// Sleep for a bit.
		
		
    } 
	catch (e) {
        log(e);
    }
}

// Handle an incoming HTTP request on a socket. 
// This function is complete (unless and until you tackle the "optional extension" bit of the lab).
function handleHttpRequest(socket) {
    var out       = socket.getOutputStream();
    var output    = new PrintWriter(out);
    var inReader  = new InputStreamReader(socket.getInputStream(), 'utf-8');
    var bufReader = new BufferedReader(inReader);
    
	// Read all the lines in the incoming HTTP request.
    var lines = readLines(bufReader);   
    if (lines.length > 0) {

		// The first line of the HTTP request will be something like "GET /SomeFilePath HTTP/1.1".
		// Split the first line of the HTTP request into tokens. 
		var header = lines[0].split(/\b\s+/);
		
		// If the first token is "GET", i.e. if it's an HTTP GET request...
        if (header[0] === "GET") {

			// Get the requested filepath.
			var URI = header[1].split(/\?/);
            var path = String(URI[0]);
			log("Received request for " + path);
			
            try {
				// TODO 6 (IF TIME PERMITS):
				// Enhance this code, so if the requested file ends with .jjsp, load it as a Nashorn JavaScript file to generate HTML dynamically.

                // Unless and until you tackle the "optional extension" bit of the lab,
				// just send the requested file (e.g. an HTML file, image, etc.) back to the client.
				sendFile(output, out, path);
            } 
			catch (e) {
				log(e);
				
				// Send the 404 error page back to the client.
                sendHttpResponse(output, "HTTP/1.0 404 Not Found", "text/html", FILE_NOT_FOUND_PAGE);
            }
        }
    }  
    output.flush();
    bufReader.close();
    socket.close();
}


// Read all the lines from a BufferedReader (we use this function to read the incoming HTTP request).
// This function is complete.
function readLines(bufReader) {

    var lines = [];    
    try {
        var line;
        while (line = bufReader.readLine()) {
            lines.push(line);
        }
    } 
	catch (e) {
		log(e);
	}
    return lines;
}


// Send an HTTP response back to the client, with a simple HTTP header and the specified HTML body content.
// This function is complete.
function sendHttpResponse(output, status, type, content) {
	
	// Send the HTTP header.
	sendBytes(output, status + CRLF);
    sendBytes(output, "Server: Simple Nashorn HTTP Server" + CRLF);
    sendBytes(output, "Content-type: " + type + CRLF);
    sendBytes(output, "Content-Length: " + content.length + CRLF);
    
	// Send a blank line, to separate the HTTP header from the HTTP body.
	sendBytes(output, CRLF);
    
	// Send the specified content as the HTTP body.
	sendBytes(output, content);
}


// Send the requested file (e.g. an HTML file, image, etc.) back to the client.
// This function is complete.
function sendFile(output, out, path) {

    var file = new FileInputStream("." + path);
    var type = contentType(path);
	
   	// Send the HTTP header.
	sendBytes(output, "HTTP/1.0 200 OK" + CRLF);
    sendBytes(output, "Server: Simple Nashorn HTTP Server" + CRLF);
    sendBytes(output, "Content-type: " + type + CRLF);
    sendBytes(output, "Content-Length: " + file.available() + CRLF);

	// Send a blank line, to separate the HTTP header from the HTTP body.
    sendBytes(output, CRLF);
    output.flush();
    
	// Send the specified file as the HTTP body.
    var buffer = new ByteArray(1024);
    var bytes = 0;
    while ((bytes = file.read(buffer)) != -1) {
        out.write(buffer, 0, bytes);
    }
}


// Helper function, to deduce the MIME type of a file (based on its file extension).
// This function is complete.
function contentType(path) {

	path = path.toLowerCase();
	
    if (path.endsWith(".htm") || path.endsWith(".html")) {
      return "text/html";
    } 
	else if (path.endsWith(".css")) {
      return "text/css";
    } 
	else if (path.endsWith(".txt")) {
      return "text/plain";
    } 
	else if (path.endsWith(".jpg") || path.endsWith(".jpeg")) {
      return "image/jpeg";
    } 
	else if (path.endsWith(".gif")) {
      return "image/gif";
    } 
	else {
      return "application/octet-stream";
    }
}


// Helper function, to send a line of bytes back to the client. 
// This function is complete.
function sendBytes(output, line) {
    output.write(String(line));
}


// Helper function, to write a log message to the server command window.
// This function is complete.
function log(msg) {
	print("[" + new Date() + "] " + msg);
}