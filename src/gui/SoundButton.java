package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.media.AudioClip;

public class SoundButton extends Button {

	private ImageView soundOn, soundOff;
	private boolean isOn;
	private AudioClip mainSong = new AudioClip(
			this.getClass().getResource("/Mission Impossible Recorder.mp3").toString());
	private AudioClip gameOverSong = new AudioClip(this.getClass().getResource("/gameoversong.mp3").toString());
	private String currentSong;

	public SoundButton() {
		isOn = true;
		soundOn = new ImageView(new Image(ClassLoader.getSystemResource("SoundOn.png").toString()));
		soundOff = new ImageView(new Image(ClassLoader.getSystemResource("SoundOff.png").toString()));
		this.getChildren().addAll(soundOn, soundOff);
		this.setGraphic(soundOn);
		currentSong = "mainSong";
		this.setAlignment(Pos.CENTER);
	}

	public Boolean isSoundOn() {
		return isOn;
	}

	public void Mute() {
		this.isOn = false;
		this.setGraphic(soundOff);
		this.stopMainSong();
		this.stopGameOverSong();
	}

	public void unMute() {
		this.isOn = true;
		this.setGraphic(soundOn);
		if (currentSong.equals("mainSong")) {
			this.playMainSong();
		} else if (currentSong.equals("gameOverSong")) {
			this.playGameOverSong();
		}

	}
	
	public void setSong (String song) {
		if (song.equals("gameOverSong") || song.equals("mainSong")) {
			currentSong = song;
		}
	}

	public void playMainSong() {
		if (isSoundOn()) {
			this.mainSong.play();
		}
	}

	public void stopMainSong() {
		this.mainSong.stop();
	}

	public void stopGameOverSong() {
		this.gameOverSong.stop();
	}

	public void playGameOverSong() {
		if (isSoundOn()) {
			this.gameOverSong.play();
		}
	}
}