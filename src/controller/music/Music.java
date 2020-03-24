package controller.music;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Music {
	public static void PlayMusic(String path) {
		InputStream musics;
		try
		{
			musics=new FileInputStream(new File (path));
			AudioStream BGM=new AudioStream(musics) ;
			AudioPlayer.player.start(BGM);
		}
		catch(IOException error) {
			System.out.print("file not found");
		}
	}

}
