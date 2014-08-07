package ro.generic.util;

/**
 * This class implements Base64 encoding for strings and byte arrays.
 * Bit sequences needed for masks :
 * 0xFC = 11111100
 * 0x03 = 00000011
 * 0xF0 = 11110000
 * 0x0F = 00001111
 * 0xC0 = 11000000
 * 0x3F = 00111111
 * 0x30 = 00110000
 * 0x3C = 00111100
 *
 * @author Popa Ciprian ,
 * @version 1.0 beta 28.02.2000
 */

public final class Base64 {

	private static final String stringDictionary = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="; // Base64 dictionary as string
	private static final byte bytesDictionary[] = stringDictionary.getBytes();                                         // Base64 dictionary as bytes
	private static final byte BYTE_PAD = 0x3D;                                                                // special byte/pad used in Base64 encoding ['=']

	/**
	 * Encode a string based on Base64 encoding algorithm.
	 *
	 * @param str 'String' - input string , to encode
	 * @return 'String' - encoded result
	 */
	public final static String encode (String str) {
		String ret = new String(encode(str.getBytes()));
		return ret;
	}

	/**
	 * Encode a byte array based on Base64 encoding algorithm.
	 *
	 * @param inArray 'byte[]' - input byte array , to encode
	 * @return 'byte[]' - encoded result
	 */
	public final static byte[] encode (byte inArray[]) {
		int size = inArray.length;
		int remainder = size % 3;
		byte outArray[] = new byte[((int)size / 3) * 4 + ((remainder == 0) ? 0 : 4)];  // calculate out size
		int index, count, length;
		byte byte1, byte2, byte3;
		length = index = count = byte1 = 0;
		while (index < size) {
			length = size - index;  // get remainder
			byte1 = inArray[index]; // byte1 is assigned here
			if (length < 3)           // reminder
			{
				break;
			}
			byte2 = inArray[index + 1];
			byte3 = inArray[index + 2];
			outArray[count++] = bytesDictionary[byte1 >> 2];
			outArray[count++] = bytesDictionary[byte1 << 4 & 0x30 | byte2 >> 4 & 0x0F];
			outArray[count++] = bytesDictionary[byte2 << 2 & 0x3C | byte3 >> 6 & 0x03];
			outArray[count++] = bytesDictionary[byte3 & 0x3F];
			index += 3;  // skip 3 bytes
		}
		if (length == 1)  // remainder == 1 [2 padding]
		{
			outArray[count++] = bytesDictionary[byte1 >> 2];
			outArray[count++] = bytesDictionary[byte1 << 4 & 0x30];
			outArray[count++] = BYTE_PAD;
			outArray[count++] = BYTE_PAD;
		} else if (length == 2) // remainder == 2 [1 padding]
		{
			byte2 = inArray[index + 1];
			outArray[count++] = bytesDictionary[byte1 >> 2];
			outArray[count++] = bytesDictionary[byte1 << 4 & 0x30 | byte2 >> 4 & 0x0F];
			outArray[count++] = bytesDictionary[byte2 << 2 & 0x3C];
			outArray[count++] = BYTE_PAD;
		}
		return outArray;
	}
}
