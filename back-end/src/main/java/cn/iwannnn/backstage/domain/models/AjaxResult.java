package cn.iwannnn.backstage.domain.models;

import java.util.HashMap;

import cn.iwannnn.backstage.constants.HttpStatus;

public class AjaxResult extends HashMap<String, Object> {

	public static final String CODE_TAG = "code";
	public static final String MSG_TAG = "msg";
	public static final String DATA_TAG = "data";

	public AjaxResult() {
	}

	public AjaxResult(int code, String msg) {
		super.put(CODE_TAG, code);
		super.put(MSG_TAG, msg);
	}

	public AjaxResult(int code, String msg, Object data) {
		super.put(CODE_TAG, code);
		super.put(MSG_TAG, msg);
		if (data != null)
			super.put(DATA_TAG, data);
	}

	public static AjaxResult success() {
		return AjaxResult.success("success");
	}

	public static AjaxResult success(Object data) {
		return AjaxResult.success("success", data);
	}

	public static AjaxResult success(String msg) {
		return AjaxResult.success(msg, null);
	}

	public static AjaxResult success(String msg, Object data) {
		return new AjaxResult(HttpStatus.SUCCESS, msg, data);
	}

	public static AjaxResult error() {
		return AjaxResult.error("error");
	}

	public static AjaxResult error(Object data) {
		return AjaxResult.error("error", data);
	}

	public static AjaxResult error(String msg) {
		return AjaxResult.error(msg, null);
	}

	public static AjaxResult error(int code, String msg) {
		return AjaxResult.error(code, msg, null);
	}

	public static AjaxResult error(String msg, Object data) {
		return AjaxResult.error(HttpStatus.ERROR, msg, data);
	}

	public static AjaxResult error(int code, String msg, Object data) {
		return new AjaxResult(code, msg, data);
	}
}
