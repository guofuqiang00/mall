package com.mall.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class SerializeUtil {
	private static Log log = LogFactory.getLog(SerializeUtil.class);

	protected static String charset = "UTF-8";

	public static <T> T decodeObject(byte[] b) {
		return (T) deserialize(decompress(b));
	}

	public static byte[] encodeObject(Object o) {
		byte[] b = serialize(o);
		return compress(b);
	}

	/**
	 * Decode the string with the current character set.
	 */
	public static String decodeString(byte[] data) {
		String rv = null;
		try {
			if (data != null) {
				rv = new String(data, charset);
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return rv;
	}

	/**
	 * Encode a string into the current character set.
	 */
	public static byte[] encodeString(String in) {
		byte[] rv = null;
		try {
			rv = in.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return rv;
	}

	/**
	 * Get the bytes representing the given serialized object.
	 */
	public static byte[] serialize(Object o) {
		if (o == null) {
			throw new NullPointerException("Can't serialize null");
		}
		byte[] rv = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream os = null;
		try {
			bos = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bos);
			os.writeObject(o);
			os.close();
			bos.close();
			rv = bos.toByteArray();
		} catch (IOException e) {
			throw new IllegalArgumentException("Non-serializable object", e);
		} finally {
			CloseUtil.close(os);
			CloseUtil.close(bos);
		}
		return rv;
	}

	/**
	 * Get the object represented by the given serialized bytes.
	 */
	private static Object deserialize(byte[] in) {
		Object rv = null;
		ByteArrayInputStream bis = null;
		//ObjectInputStream is = null;
		FakeObjectInputStream is = null;
		try {
			if (in != null) {
				bis = new ByteArrayInputStream(in);
				//is = new ObjectInputStream(bis);
				is = new FakeObjectInputStream(bis);
				rv = is.readObject();
				is.close();
				bis.close();
			}
		} catch (IOException e) {
			log.warn("Caught IOException decoding "
					+ (in == null ? 0 : in.length) + " bytes of data", e);
		} catch (ClassNotFoundException e) {
			log.warn("Caught CNFE decoding " + (in == null ? 0 : in.length)
					+ " bytes of data", e);
		} finally {
			CloseUtil.close(is);
			CloseUtil.close(bis);
		}
		return rv;
	}

	/**
	 * Compress the given array of bytes.
	 */
	private static byte[] compress(byte[] in) {
		if (in == null) {
			throw new NullPointerException("Can't compress null");
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		GZIPOutputStream gz = null;
		try {
			gz = new GZIPOutputStream(bos);
			gz.write(in);
		} catch (IOException e) {
			throw new RuntimeException("IO exception compressing data", e);
		} finally {
			CloseUtil.close(gz);
			CloseUtil.close(bos);
		}
		byte[] rv = bos.toByteArray();
		log.debug("Compressed " + in.length + " bytes to " + rv.length);
		return rv;
	}

	/**
	 * Decompress the given array of bytes.
	 *
	 * @return null if the bytes cannot be decompressed
	 */
	private static byte[] decompress(byte[] in) {
		ByteArrayOutputStream bos = null;
		if (in != null) {
			ByteArrayInputStream bis = new ByteArrayInputStream(in);
			bos = new ByteArrayOutputStream();
			GZIPInputStream gis = null;
			try {
				gis = new GZIPInputStream(bis);

				byte[] buf = new byte[8192];
				int r = -1;
				while ((r = gis.read(buf)) > 0) {
					bos.write(buf, 0, r);
				}
			} catch (IOException e) {
				log.error("Failed to decompress data", e);
			} finally {
				CloseUtil.close(gis);
				CloseUtil.close(bis);
				CloseUtil.close(bos);
			}
		}
		return bos == null ? null : bos.toByteArray();
	}

	private static final class CloseUtil {
		private CloseUtil() { }
		public static void close(Closeable closeable) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
					log.error("Unable to close " + e.getMessage(), e);
				}
			}
		}
	}

	public static <T> T deserialize(byte[] in, Class<T>...requiredType) {
		Object rv = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream is = null;
		try {
			if (in != null) {
				bis = new ByteArrayInputStream(in);
				is = new ObjectInputStream(bis);
				rv = is.readObject();
			}
		} catch (Exception e) {
		} finally {
			close(is);
			close(bis);
		}
		return (T) rv;
	}
	private static void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
			}
		}

	}
	public static byte[] beanSerialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {

		}
		return null;
	}

	public static Object beanUnserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {

		}
		return null;
	}
}

