var Random = java.util.Random;

var generator = new Random();
var number = generator.nextDouble() * 100;
var examMark = Math.floor(number) + 1;

print("Random exam mark: " + examMark);
