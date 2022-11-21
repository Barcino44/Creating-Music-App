package model;
import java.util.Date;
public abstract class UserConsumer extends User{

	public UserConsumer(String username, String id, Date vinculationDate) {
		super(username, id, vinculationDate);
	}
	/**
	 * addPlayList description: It adds the playlist in a determinated consumer.
	 * @param  playlist: Playlist - It represents the playlist that is going to be added.
	 * @return boolean - It validates if playlist could be added. 
	 */
	public abstract boolean addPlayList(PlayList playlist);
	/**
	 * showCodePlaylist: It shows the code of a playlist.
	 * @param  playlist: String - It represents the name of the which is going show the code.
	 * @return String - It is the code of the playlist. 
	 */
	public abstract String showCodePlaylist(PlayList playlist);
	/**
	 * playlistPosByName: It searches the position of a playlist using the name.
	 * @param  playlistName: String - It is the name of the playlist. 
	 * @return int - It represents the position of the playlist.
	 */
	public abstract int playlistPosByName(String playlistName);
	/**
	 * showCodeAndMatrizWithPlayListName: It shows the code and the matriz of a playlist using the name.
	 * @param  playlistName: String - It is the name of the playlist.
	 * @return String - It represents the code and the matriz of the playlist.
	 */
	public abstract String showCodeAndMatrizWithPlayListName(String playlistName);
	/**
	 * showAudiosAddedInPlaylist: It shows the audios added in a playlist.
	 * @param  playlistName: String - It is the name of the playlist.
	 * @return String - It represents the audios added in the playlist.
	 */
	public abstract String showAudiosAddedInPlaylist(String playlistName);
	/**
	 * getTypePlaylist: It gets the type of a playlist using the name.
	 * @param  playlistName: String - It is the name of the playlist.
	 * @return int - It is a number according the type of playlist (1,2 or 3).
	 */
	public abstract int getTypePlaylist(String playlistName);
	/**
	 * addAudiotoPlayList: It adds an audio in a playlist.
	 * @param  playlistName: String - It is the name of the playlist.
	 * @param  audio: Audio - It represents the audio that is going to be added.
	 * @return boolean - It is a confirmation.
	 */
	public abstract boolean addAudiotoPlayList(String playlistName, Audio audio);
	/**
	 * deleteAudioInPlaylist: It deletes an audio in a playlist.
	 * @param  playlistName: String - It is the name of the playlist.
	 * @param  audioName: String - It represents the name of audio that is going to be deleted.
	 * @return boolean - It is a confirmation.
	 */
	public abstract boolean deleteAudioInPlaylist(String playlistName,String audioName);
	/**
	 * playAudioInPlaylist: It plays an audio in a playlist.
	 * @param  playlistName: String - It is the name of the playlist.
	 * @param  audioName: String - It represents the name of audio that is going to be played.
	 * @return String - It is a message that shows that the audio is playing.
	 */
	public abstract String playAudioInPlaylist(String playlistName, String audioName);
	/**
	 * validateIfSongCanbeBought: It validates if a song can be bought.
	 * @param  songName: String - It represents the name of the song that is going to be bought.
	 * @return boolean - It is a validation.
	 */
	public abstract boolean validateIfSongCanbeBought(String songName);
	/**
	 * showMostListenedSongGenre: It shows the most listened song genre of a consumer.
	 * @return String - It is the most listened song genre.
	 */
	public abstract String showMostListenedSongGenre();
	/**
	 * showMostListenedPodcastCategory: It shows the most listened podcast category of a consumer.
	 * @return String - It is the most listened podcast category.
	 */
	public abstract String showMostListenedPodcastCategory();
}

		
	