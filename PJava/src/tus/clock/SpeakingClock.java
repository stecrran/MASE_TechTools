package tus.clock;

import java.util.Date;

public class SpeakingClock {
	
	private final Clock clock;
	private final SpeechSynthesizer speechSynthizer;
	private final SpeakingClockEngine engine;
	
	
	public SpeakingClock(Clock clock, SpeechSynthesizer speechSynthesizer, SpeakingClockEngine engine) {
		this.clock = clock;
		this.speechSynthizer = speechSynthesizer;
		this.engine = engine;
		
	}
	
	public void tellTheTime() {
		Date currentTime = clock.getTime();
		String spokenText = engine.asSpeech(currentTime);
		speechSynthizer.speak(spokenText);
	}
}
