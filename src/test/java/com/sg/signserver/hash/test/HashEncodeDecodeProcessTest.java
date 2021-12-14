package com.sg.signserver.hash.test;



import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.jmrtd.lds.SODFile;




public class HashEncodeDecodeProcessTest {

	public static void main(String args[]) throws IOException, NoSuchAlgorithmException{
		Properties p = new Properties();
		p.load(new FileInputStream(System.getenv("conffile")));
		String input = p.getProperty("input_string");
		
		System.out.println("input string: "+input);
		
		Boolean isDebug = Boolean.valueOf(p.getProperty("debug_mode")) ;
		
		String operations = p.getProperty("operations");
		
		String[] opslist = operations.split(",");
		
		
		Object[] msg = new Object[1];
		msg[0] = input;
		for (String op : opslist) {
			op=op.trim();
			if(op.equals("decbase64")) {
				if(isDebug) {
					System.out.println("Decode base 64:");
				}
				byte[] decodeBase64 = Base64.decodeBase64((byte[])msg[0]);
				msg[0] = decodeBase64;
			}else if(op.equals("encbase64")) {
				if(isDebug) {
					System.out.println("Encode base 64:");
				}
				
				byte[] encodeBase64 = Base64.encodeBase64((byte[]) msg[0]);
				msg[0] = encodeBase64;
			}else if(op.equals("sha256")) {
				
				if(isDebug) {
					System.out.println("apply sha 256:");
				}
				
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] hashed = digest.digest((byte[]) msg[0]);
				msg[0] = hashed;
			}else if(op.equals("str_to_byte")) {
				if(isDebug) {
					System.out.println("str to byte ");
				}
				msg[0] = ((String)msg[0]).getBytes();
				
			}else if(op.equals("print")) {
				if(isDebug) {
					System.out.println("Print out:");
				}
				System.out.println(msg[0]);
			}
			else if(op.equals("print_as_str")) {
				if(isDebug) {
					System.out.println("Print out as string:");
				}
				System.out.println(new String((byte[])msg[0]));
			}else if(op.equals("read_file_as_byte")) {
				
				if(isDebug) {
					System.out.println("read file as bytes:");
				}
//				InputStreamReader isr = new InputStreamReader(
//						new FileInputStream(new File((String)msg[0])));
				
//				BufferedInputStream bis = new BufferedInputStream(
//						new FileInputStream(new File((String)msg[0])));
				
				msg[0] = FileUtils.readFileToByteArray(new File((String)msg[0]));

			}else if(op.equals("save_file_as_byte")) {
				String output = p.getProperty("output_string");

				if(isDebug) {
					System.out.println("save file as bytes: "+output);
				}
				FileOutputStream fos = new FileOutputStream(new File(
						output));
				fos.write((byte[])msg[0]);
				fos.close();
			}
		}
	}
}
