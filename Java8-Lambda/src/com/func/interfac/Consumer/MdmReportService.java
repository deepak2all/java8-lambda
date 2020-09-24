package com.func.interfac.Consumer;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class MdmReportService {

	public void reportRequest(Report report, Map<String, String> paramMap,
			String userId, String participantId){
		MdmReportRequest reportRequest = createReportReq(report, paramMap, userId, participantId);
		Gson gson = new Gson();
		System.out.println("JSON request sent :: " + gson.toJson(reportRequest, MdmReportRequest.class));
	}
	
	private MdmReportRequest createReportReq(Report report, Map<String, String> paramMap, String userId,
			String participantId) {
		// TODO Auto-generated method stub
		MdmReportRequest.Builder builder = new MdmReportRequest.Builder(userId, participantId);
		builder.setReportName(report.getName());
		for(Map.Entry<String, String> entry : paramMap.entrySet()){
			//builder = builder.addParameter(entry.getKey(), entry.getValue());
			// Use addItem instead of addParameter, to modify JSON to include "schedule"
			builder = builder.addItem(entry.getKey(), entry.getValue());
		}
		return builder.build();
	}

	
	public static void main (String[] args) {
		Report rep = new Report();
		rep.setName("Metering Data");
		// These values of the map are dynamically populated from the UI
		// Depending on the report and the values chosen by the user
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("DeliverTo", "MDP");
		paramMap.put("AsAtDate", "2020-05-14");
		paramMap.put("MDP", "ACTIONM");
		paramMap.put("FromDate", "2020-05-09");
		paramMap.put("ToDate", "2020-05-14");
		paramMap.put("RunDate", "2020-05-14");
		MdmReportService mdmReportService = new MdmReportService();
		mdmReportService.reportRequest(rep, paramMap, "DEEPAKKA", "NEMMCO");
	}
	
	public static class Report {
		private String name;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}



	
