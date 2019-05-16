package logic;

import gui.SoundButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;

public class SoundManager {

	private SoundButton soundButton;

	public SoundManager(SoundButton soundButton) {
		this.soundButton = soundButton;
		this.setUpSoundButtonEvent(soundButton);

	}

	public void setUpSoundButtonEvent(SoundButton soundButton) {
		soundButton.setOnAction(new SoundButtonEventHandler());

	}

	private class SoundButtonEventHandler implements EventHandler<ActionEvent> {

		public SoundButtonEventHandler() {

		}

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (soundButton.isSoundOn()) {
				soundButton.Mute();
			} else
				soundButton.unMute();
		}

	}

	public void playMainSong() {
		if (soundButton.isSoundOn()) {
			soundButton.playMainSong();
		}
	}

	public void stopMainSong() {
		soundButton.stopMainSong();
	}

	public void stopGameOverSong() {
		soundButton.stopGameOverSong();
	}

	public void playGameOverSong() {
		if (soundButton.isSoundOn()) {
			soundButton.playGameOverSong();
		}
	}

	public SoundButton getSoundButton() {
		return this.soundButton;
	}
}
