package com.test.APIAutomation.OneDat.Pojo;

import java.util.List;

public class Courses {

	private List<WebAutomationCourses> webAutomation;
	private List<ApiCourses> api;
	private List<MobileCourses> mobile;
	public List<WebAutomationCourses> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomationCourses> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<ApiCourses> getApi() {
		return api;
	}
	public void setApi(List<ApiCourses> api) {
		this.api = api;
	}
	public List<MobileCourses> getMobile() {
		return mobile;
	}
	public void setMobile(List<MobileCourses> mobile) {
		this.mobile = mobile;
	}
}
