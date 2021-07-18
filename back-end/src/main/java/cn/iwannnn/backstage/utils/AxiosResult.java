package cn.iwannnn.backstage.utils;

import java.util.HashMap;

public class AxiosResult extends HashMap<String, Object> {

	public static final String CODE_TAG = "code";
	public static final String MSG_TAG = "msg";
	public static final String DATA_TAG = "data";

	public AxiosResult() {
	}

	public AxiosResult(int code, String msg) {
		super.put(CODE_TAG, code);
		super.put(MSG_TAG, msg);
	}

	public AxiosResult(int code, String msg, Object data) {
		super.put(CODE_TAG, code);
		super.put(MSG_TAG, msg);
		if (data != null)
			super.put(DATA_TAG, data);
	}

	public static AxiosResult success() {
		return AxiosResult.success("success");
	}

	public static AxiosResult success(Object data) {
		return AxiosResult.success("success", data);
	}

	public static AxiosResult success(String msg) {
		return AxiosResult.success(msg, null);
	}

	public static AxiosResult success(String msg, Object data) {
		return new AxiosResult(HttpStatues.SUCCESS, msg, data);
	}

	public static AxiosResult error() {
		return AxiosResult.error("error");
	}

	public static AxiosResult error(Object data) {
		return AxiosResult.error("error", data);
	}

	public static AxiosResult error(String msg) {
		return AxiosResult.error(msg, null);
	}

	public static AxiosResult error(String msg, Object data) {
		return AxiosResult.error(HttpStatues.ERROR, msg, data);
	}

	public static AxiosResult error(int code, String msg, Object data) {
		return new AxiosResult(code, msg, data);
	}
}
