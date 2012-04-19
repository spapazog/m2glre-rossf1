package universite.toulouse.moodlexmlapi.core;

public class InvalidStreamSizeException extends Exception {
	
	private Long maxSize ;
	private Long streamSize ;
	
	/**
	 * @return the maxSize
	 */
	public Long getMaxSize() {
		return maxSize;
	}

	/**
	 * @return the streamSize
	 */
	public Long getStreamSize() {
		return streamSize;
	}

	public InvalidStreamSizeException(Long maxSize, Long streamSize) {
		super("invalidStreamSizeException");
		this.maxSize = maxSize ;
		this.streamSize = streamSize ;
	}


}
