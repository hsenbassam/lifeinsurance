package com.lifeinsurance.utils;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class KeySingleton {

	private static volatile KeySingleton instance = null;
	private static byte[] SIGN_KEY;
	private KeySingleton() {}

	public static KeySingleton getInstance() {

		if (instance == null) {
			synchronized (KeySingleton.class) {
				if (instance == null) {
					instance = new KeySingleton();
				}
			}
		}
		return instance;
	}

	public byte[] getKey() {
		return SIGN_KEY;
	}
	
	public void generateKey() {
		SIGN_KEY =  MacProvider.generateKey(SignatureAlgorithm.HS256).getEncoded();
	}
	
	

}
