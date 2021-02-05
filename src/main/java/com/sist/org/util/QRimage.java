package com.sist.org.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import net.glxn.qrgen.javase.QRCode;

public class QRimage {

	
	public byte[] generate(String text, int width, int height) {

		try (ByteArrayOutputStream bos = QRCode.from(text).withSize(width, height).stream();) {

			return bos.toByteArray();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
