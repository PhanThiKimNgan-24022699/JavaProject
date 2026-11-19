interface AudioPlayable {
    void playAudio(String file);
}

interface VideoPlayable {
    void playVideo(String file);
}

class AudioPlayer implements AudioPlayable {
    @Override
    public void playAudio(String file) {
        System.out.println("Đang phát âm thanh (Audio): " + file);
    }
}

class VideoPlayer implements VideoPlayable {
    @Override
    public void playVideo(String file) {
        System.out.println("Đang phát hình ảnh (Video): " + file);
    }
}

class MediaPlayer {
    private AudioPlayable audioPlayer;
    private VideoPlayable videoPlayer;

    public MediaPlayer(AudioPlayable audio, VideoPlayable video) {
        this.audioPlayer = audio;
        this.videoPlayer = video;
    }

    public void playAudio(String file) {
        if (audioPlayer != null) {
            audioPlayer.playAudio(file);
        }
    }

    public void playVideo(String file) {
        if (videoPlayer != null) {
            videoPlayer.playVideo(file);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AudioPlayable audio = new AudioPlayer();
        VideoPlayable video = new VideoPlayer();

        MediaPlayer mediaPlayer = new MediaPlayer(audio, video);

        mediaPlayer.playAudio("nhac_nen_uet.mp3");
        mediaPlayer.playVideo("bai_giang_oop.mp4");
    }
}