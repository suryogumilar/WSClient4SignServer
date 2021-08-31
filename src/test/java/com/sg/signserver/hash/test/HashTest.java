package com.sg.signserver.hash.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class HashTest {

	@Test
	public void test() throws NoSuchAlgorithmException {
		// hash using sha-256
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		String text = "P<UTOERIKSSON<<ANNA<MARIA<<<<<<<<<<<<<<<<<<<";
		text += "L898902C36UTO7408122F1204159ZE184226B<<<<<10";
		byte[] hash = digest.digest(text.getBytes());
		System.out.println(new String(hash));

		// hash base64
		hash = java.util.Base64.getEncoder().encode(text.getBytes());
		System.out.println("base64 of MRZ:");
		System.out.println(new String(hash));

		System.out.println("base64 of digest of MRZ:");
		hash = java.util.Base64.getEncoder().encode(hash);
		System.out.println(new String(hash));

		System.out.println("base64 (Stringvers) of digest of MRZ:");
		String stringhash = java.util.Base64.getEncoder().encodeToString(hash);
		System.out.println(stringhash);

		System.out.println("base64 of digest of MRZ using apache:");

		byte[] encoded64 = Base64.encodeBase64(hash);
		System.out.println(new String(encoded64));

		System.out.println("base64 (most significat 16 bytes - pretend) of digest of MRZ using apache:");
		String textsub = text.substring(0, 15);
		System.out.println(textsub.length());
		byte[] hashsub = digest.digest(text.getBytes());
		encoded64 = Base64.encodeBase64(hashsub);
		System.out.println(new String(encoded64));
//		 		just sample if you want to decode
//				hash = java.util.Base64.getDecoder().decode(text.getBytes());
//				System.out.println(new String(hash));
	}

}
