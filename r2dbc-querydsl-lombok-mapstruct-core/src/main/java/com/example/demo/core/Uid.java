package com.example.demo.core;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 统一系统 uid
 * 
 * @author huahouye
 *
 */
@JsonSerialize(using = UidSerializer.class)
public class Uid implements Serializable, Comparable<Uid> {

	private static final long serialVersionUID = 1L;

	private String uidValue;

	public Uid() {
		this.uidValue = UUID.randomUUID().toString().replace("-", "");
	}

	public Uid(String uidValue) {
		Objects.requireNonNull(uidValue, "The value must be null");
		this.uidValue = uidValue.toString().replace("-", "");
	}

	public static Uid of(String uidValue) {
		Objects.requireNonNull(uidValue, "The value must be null");
		return new Uid(uidValue.toString().replace("-", ""));
	}

	public static Uid getUid() {
		return new Uid(UUID.randomUUID().toString().replace("-", ""));
	}

	public boolean isValidated() {
		if (Objects.nonNull(uidValue) && !uidValue.isEmpty() && containsText(uidValue)) {
			return true;
		}
		return false;
	}

	public boolean isInvalidated() {
		return !isValidated();
	}

	public static boolean isValidated(Uid uid) {
		if (Objects.nonNull(uid) && Objects.nonNull(uid.toString()) && !uid.toString().isEmpty()
				&& containsText(uid.toString())) {
			return true;
		}
		return false;
	}

	public static boolean isInvalidated(Uid uid) {
		return !isValidated(uid);
	}

	private static boolean containsText(CharSequence str) {
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return uidValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (Objects.isNull(obj)) {
			return false;
		}
		return uidValue.equals(obj.toString());
	}

	@Override
	public int compareTo(Uid o) {
		return uidValue.compareTo(o.toString());
	}

	@Override
	public int hashCode() {
		return uidValue.hashCode();
	}
}