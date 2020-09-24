package com.func.interfac.Consumer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import com.google.gson.annotations.SerializedName;

public class MdmReportRequest {

	private static final String DELIVER_TO = "DeliverTo";
	private static final String RUNDATE = "RunDate";
	private static final String SCHEDULER_MDP = "SchedulerMDP";
	
	private static final List<String> schedulerItems = Arrays.asList(DELIVER_TO, RUNDATE, SCHEDULER_MDP);
	
	/*
	 * BiConsumer
	 * takes in 2 inputs, using accept method
	 * Does computation
	 * But doesn't return any output
	 */
	private static Map<String, BiConsumer<Schedule, String>> scheduleMap = new HashMap<>();
	
	static {
		scheduleMap.put(DELIVER_TO, Schedule::setDeliverTo);
		scheduleMap.put(RUNDATE, Schedule::setScheduledRunDateTime);
		scheduleMap.put(SCHEDULER_MDP, Schedule::setMdp);
	}
	
	public static class Schedule {
		@SerializedName("scheduledRunDateTime")
		private String scheduledRunDateTime;
		
		@SerializedName("deliverTo")
		private String deliverTo;
		
		@SerializedName("mdp")
		private String mdp;
		
		@SerializedName("incrementType")
		private String incrementType;
		
		@SerializedName("incrementFactor")
		private String incrementFactor;
		
		@SerializedName("expiryDate")
		private String expiryDate;
		
		@SerializedName("deleteFlag")
		private String deleteFlag;

		public String getScheduledRunDateTime() {
			return scheduledRunDateTime;
		}

		public void setScheduledRunDateTime(String scheduledRunDateTime) {
			this.scheduledRunDateTime = scheduledRunDateTime;
		}

		public String getDeliverTo() {
			return deliverTo;
		}

		public void setDeliverTo(String deliverTo) {
			this.deliverTo = deliverTo;
		}

		public String getMdp() {
			return mdp;
		}

		public void setMdp(String mdp) {
			this.mdp = mdp;
		}

		public String getIncrementType() {
			return incrementType;
		}

		public void setIncrementType(String incrementType) {
			this.incrementType = incrementType;
		}

		public String getIncrementFactor() {
			return incrementFactor;
		}

		public void setIncrementFactor(String incrementFactor) {
			this.incrementFactor = incrementFactor;
		}

		public String getExpiryDate() {
			return expiryDate;
		}

		public void setExpiryDate(String expiryDate) {
			this.expiryDate = expiryDate;
		}

		public String getDeleteFlag() {
			return deleteFlag;
		}

		public void setDeleteFlag(String deleteFlag) {
			this.deleteFlag = deleteFlag;
		}
	}
	
	public static class Transaction {
		@SerializedName("transactionID")
		private String transactionID;
		
		@SerializedName("transactionDate")
		private String transactionDate;
		
		@SerializedName("reportRequest")
		private ReportRequest reportRequest;
		
		@SerializedName("schedule")
		private Schedule schedule;

		public String getTransactionID() {
			return transactionID;
		}

		public void setTransactionID(String transactionID) {
			this.transactionID = transactionID;
		}

		public String getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(String transactionDate) {
			this.transactionDate = transactionDate;
		}

		public ReportRequest getReportRequest() {
			return reportRequest;
		}

		public void setReportRequest(ReportRequest reportRequest) {
			this.reportRequest = reportRequest;
		}

		public Schedule getSchedule() {
			return schedule;
		}

		public void setSchedule(Schedule schedule) {
			this.schedule = schedule;
		}
	}
	
	public static class ReportRequest {
		@SerializedName("reportParameters")
		private List<ReportParameter> reportParameters;

		public List<ReportParameter> getReportParameters() {
			return reportParameters;
		}

		public void setReportParameters(List<ReportParameter> reportParameters) {
			this.reportParameters = reportParameters;
		}
		
	}
	
	public static class ReportParameter {
		@SerializedName("parameterName")
		private String parameterName;
		
		@SerializedName("parameterValue")
		private String parameterValue;
		public String getParameterName() {
			return parameterName;
		}
		public void setParameterName(String parameterName) {
			this.parameterName = parameterName;
		}
		public String getParameterValue() {
			return parameterValue;
		}
		public void setParameterValue(String parameterValue) {
			this.parameterValue = parameterValue;
		}
		
	}

	private String fromParticipantID;
	
	private String toParticipantID;
	
	private String messageID;
	
	private String messageDate;
	
	private String transactionGroup;
	
	private String priority;
	
	private String securityContext;
	
	private String market;
	
	private List<Transaction> transactions;
	
	public String getFromParticipantID() {
		return fromParticipantID;
	}

	public void setFromParticipantID(String fromParticipantID) {
		this.fromParticipantID = fromParticipantID;
	}

	public String getToParticipantID() {
		return toParticipantID;
	}

	public void setToParticipantID(String toParticipantID) {
		this.toParticipantID = toParticipantID;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	public String getTransactionGroup() {
		return transactionGroup;
	}

	public void setTransactionGroup(String transactionGroup) {
		this.transactionGroup = transactionGroup;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getSecurityContext() {
		return securityContext;
	}

	public void setSecurityContext(String securityContext) {
		this.securityContext = securityContext;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public static class Builder {
		private static final String REPORT_NAME = "ReportName";
		private MdmReportRequest mdmReportRequest;
		
		public Builder(String userId, String participantId) {
			mdmReportRequest = new MdmReportRequest();
			mdmReportRequest.setFromParticipantID(participantId);
			mdmReportRequest.setSecurityContext(userId);
			mdmReportRequest.setMarket("NEM");
			mdmReportRequest.setTransactions(new ArrayList<>());
			Transaction transaction = new Transaction();
			transaction.setTransactionDate(LocalDate.now().toString());
			ReportRequest reportRequest = new ReportRequest();
			reportRequest.setReportParameters(new ArrayList<>());
			transaction.setReportRequest(reportRequest);
			mdmReportRequest.getTransactions().add(transaction);
		}
		
		public Builder setReportName(String reportName){
			return addParameter(REPORT_NAME, reportName);
		}
		
		public Builder addParameter(String paramName, String paramValue){
			ReportParameter reportParameter = new ReportParameter();
			reportParameter.setParameterName(paramName);
			reportParameter.setParameterValue(paramValue);
			mdmReportRequest.getTransactions().get(0)
				.getReportRequest().getReportParameters().add(reportParameter);
			return this;
		}
		
		public MdmReportRequest build() {
			return mdmReportRequest;
		}
		
		// Appending the code to put some JSON parameters inside "schedule"
		private Builder addToSchedule(String paramName, String paramValue) {
			if(mdmReportRequest.getTransactions().get(0).getSchedule() == null) {
				mdmReportRequest.getTransactions().get(0).setSchedule(new Schedule());
			}
			scheduleMap.getOrDefault(paramName, (schedule, s) -> {})
				.accept(mdmReportRequest.getTransactions().get(0).getSchedule(), paramValue);
			return this;
		}
		
		public Builder addItem(String key, String value) {
			return schedulerItems.contains(key) ? addToSchedule(key, value) : addParameter(key, value);
		}
	}
}
