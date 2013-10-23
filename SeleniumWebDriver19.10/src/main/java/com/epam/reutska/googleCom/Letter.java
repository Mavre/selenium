package com.epam.reutska.googleCom;

public class Letter implements Comparable<Letter>{
	private String sender;
	private String subject;
	private String body;

	public String getSender() {
		return sender;
	}

	public Letter withSender(String sender) {
		this.sender = sender;
		return this;
	}

	public String getSubject() {
		return subject;
	}

	public Letter withSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public String getBody() {
		return body;
	}

	public Letter withBody(String body) {
		this.body = body;
		return this;
	}

	@Override
	public String toString() {
		return "Letter [sender=" + sender + ", subject=" + subject + ", body="
				+ body + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letter other = (Letter) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	@Override
	public int compareTo(Letter o) {
		int senderGreat = this.sender.compareTo(o.sender);
		if(senderGreat != 0){
			return senderGreat;
		} else {
			int subjectGreat = this.subject.compareTo(o.subject);
			if(subjectGreat != 0){
				return subjectGreat;
			} else {
				return this.body.compareTo(o.body);
				
			}
		}
	}
	
	
}
