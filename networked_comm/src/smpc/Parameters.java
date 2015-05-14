package smpc;

public class Parameters {

	static public long count ;
	
	static public int VIRTUAL_HOST = -1 ;

	/**
	offline phase parameters
	 */
	static public int NUMBER_OF_TRIPLETES_TOBE_GENERATED = 1;

	/**
	 * Cluster info
	 */

	static public int NUMBER_OF_PARTIES = 10 ;

	/***
	 * Computation Costs
	 */

	//I am setting these times to zero becaus they are so negligible and dont make a difference
	static public int ADDITION_TIME  = 0;
	static public int MULITIPLICATION_LOCAL_TIME = 0;
	static public int XOR_TIME  = 0;

	//Units of time are 100 uSeconds

	/**
	 * SHA256 genreation takes 50 ms per MByte of data.
	 * Since we are always using it for Integers, I assume it takes 1 ms
	 */
	static public int HASH_GENERATION_TIME = 500;

	static public int RANDOM_GEN_TIME  = 10;

	static public int SHE_ENCRYPT_TIME = 1;
	static public int SHE_DECRYPT_TIME = 1;

	/**
	 * AES genreation takes 10 ms per MByte of data.
	 * Since we are always using it for Integers, I assume it takes 1 ms
	 */
	static public int AES_ENCRYPT_TIME = 10;


	/**
	 * Network Delay
	 */
	static public int NETWORK_DELAY = 1 ;
	static public int SEND_TIME  = 1000;
	static public int RECEIVE_TIME = 1000;

	/**
	 * Offline phase paramteres
	 */

	static public boolean NEW_CIPHER_TEXT = true;
	static public int M = 40000;

	// nm = number of multiplication
	static public int N_M = 10000;

	//Number of Additions in the protocol
	static public int N_A = 10000;

	static public int N_CIPHER = 5;


	static public double getDuration(ComputationType computationType){

		int duration = 0;
		switch (computationType)
		{
			case ADDITION:
				duration = ADDITION_TIME;
				break;
			case MULITIPLICATION:
				duration = MULITIPLICATION_LOCAL_TIME;
				break;
			case RANDOM_GEN:
				duration = RANDOM_GEN_TIME;
				break;
			case SEND:
				duration = SEND_TIME;
				break;
			case RECIEVE:
				duration = RECEIVE_TIME;
				break;
			case SHE_ENCRYPT:
				duration = SHE_ENCRYPT_TIME;
				break;
			case SHE_DECRYPT:
				duration = SHE_DECRYPT_TIME;
				break;
			case AES_ENCRYPT:
				duration = AES_ENCRYPT_TIME;
				break;
			case HASH_GENERATION:
				duration = HASH_GENERATION_TIME;
				break;
			case XOR:
				duration = XOR_TIME;
				break;
		}

		return (double) duration;

	}

	public enum ComputationType{
		ADDITION,
		XOR,
		MULITIPLICATION,
		RANDOM_GEN,
		COMMIT_COMPUTATION,
		SHE_ENCRYPT,
		SHE_DECRYPT,
		SHE_MULTIPLY,
		SHE_ADD,
		SEND,
		RECIEVE,
		AES_ENCRYPT,
		HASH_GENERATION

	}

	static public double getNetworkDelay(){
		return NETWORK_DELAY ;
	}
	
	static public int getNumberOfParties(){
		return NUMBER_OF_PARTIES; 
	}

	//TODO fix this
	static public int getNumberOfMultiplications(){
		return N_M;
	}

	static public int getNumberOfCurruptedParties()
	{
		return (int) (getNumberOfParties()/16);
	}
}
