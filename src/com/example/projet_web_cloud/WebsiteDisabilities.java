package com.example.projet_web_cloud;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class WebsiteDisabilities {
	
	@PrimaryKey
	private String url;
	
	@Persistent
	private Boolean Dyslexia;
	
	@Persistent
	private Boolean Dysgraphia;
	
	@Persistent
	private Boolean Dyscalculia;
	
	@Persistent
	private Boolean AttentionDeficitDisorder;
	
	@Persistent
	private Boolean AspergerSyndrome;
	
	@Persistent
	private Boolean ColourdBrlind;
	
	@Persistent
	private Boolean PartiallySighted;
	
	@Persistent
	private Boolean Blind;
	
	@Persistent
	private Boolean HearingImparment;
	
	@Persistent
	private Boolean Deaf;
	
	@Persistent
	private Boolean UpperLimbsMobility;
	
	@Persistent
	private Boolean LowerLimbsMobility;
	
	@Persistent
	private Boolean ManuelDexterity;
	
	@Persistent
	private Boolean CoordinationDifficulties;
	
	@Persistent
	private Boolean Asthma;
	
	@Persistent
	private Boolean Epilepsy;
	
	@Persistent
	private Boolean Diabetes;
	
	@Persistent
	private Boolean PostTraumaticStressDisorder;
	
	@Persistent
	private Boolean Schizophrenia;
	
	@Persistent
	private Boolean EatingDisorders;
	
	@Persistent
	private Boolean Anxiety;
	
	@Persistent
	private Boolean ObesessiveCompulsiveDisorder;
	
	@Persistent
	private Boolean ManicDepression;
	
	@Persistent
	private Boolean Phobia;
	
	@Persistent
	private Boolean AutisticSpectrumDisorder;
	
	@Persistent
	private Boolean Depression;

	public WebsiteDisabilities(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getDyslexia() {
		return Dyslexia;
	}

	public void setDyslexia(Boolean dyslexia) {
		Dyslexia = dyslexia;
	}

	public Boolean getDysgraphia() {
		return Dysgraphia;
	}

	public void setDysgraphia(Boolean dysgraphia) {
		Dysgraphia = dysgraphia;
	}

	public Boolean getDyscalculia() {
		return Dyscalculia;
	}

	public void setDyscalculia(Boolean dyscalculia) {
		Dyscalculia = dyscalculia;
	}

	public Boolean getAttentionDeficitDisorder() {
		return AttentionDeficitDisorder;
	}

	public void setAttentionDeficitDisorder(Boolean attentionDeficitDisorder) {
		AttentionDeficitDisorder = attentionDeficitDisorder;
	}

	public Boolean getAspergerSyndrome() {
		return AspergerSyndrome;
	}

	public void setAspergerSyndrome(Boolean aspergerSyndrome) {
		AspergerSyndrome = aspergerSyndrome;
	}

	public Boolean getColourdBrlind() {
		return ColourdBrlind;
	}

	public void setColourdBrlind(Boolean colourdBrlind) {
		ColourdBrlind = colourdBrlind;
	}

	public Boolean getPartiallySighted() {
		return PartiallySighted;
	}

	public void setPartiallySighted(Boolean partiallySighted) {
		PartiallySighted = partiallySighted;
	}

	public Boolean getBlind() {
		return Blind;
	}

	public void setBlind(Boolean blind) {
		Blind = blind;
	}

	public Boolean getHearingImparment() {
		return HearingImparment;
	}

	public void setHearingImparment(Boolean hearingImparment) {
		HearingImparment = hearingImparment;
	}

	public Boolean getDeaf() {
		return Deaf;
	}

	public void setDeaf(Boolean deaf) {
		Deaf = deaf;
	}

	public Boolean getUpperLimbsMobility() {
		return UpperLimbsMobility;
	}

	public void setUpperLimbsMobility(Boolean upperLimbsMobility) {
		UpperLimbsMobility = upperLimbsMobility;
	}

	public Boolean getLowerLimbsMobility() {
		return LowerLimbsMobility;
	}

	public void setLowerLimbsMobility(Boolean lowerLimbsMobility) {
		LowerLimbsMobility = lowerLimbsMobility;
	}

	public Boolean getManuelDexterity() {
		return ManuelDexterity;
	}

	public void setManuelDexterity(Boolean manuelDexterity) {
		ManuelDexterity = manuelDexterity;
	}

	public Boolean getCoordinationDifficulties() {
		return CoordinationDifficulties;
	}

	public void setCoordinationDifficulties(Boolean coordinationDifficulties) {
		CoordinationDifficulties = coordinationDifficulties;
	}

	public Boolean getAsthma() {
		return Asthma;
	}

	public void setAsthma(Boolean asthma) {
		Asthma = asthma;
	}

	public Boolean getEpilepsy() {
		return Epilepsy;
	}

	public void setEpilepsy(Boolean epilepsy) {
		Epilepsy = epilepsy;
	}

	public Boolean getDiabetes() {
		return Diabetes;
	}

	public void setDiabetes(Boolean diabetes) {
		Diabetes = diabetes;
	}

	public Boolean getPostTraumaticStressDisorder() {
		return PostTraumaticStressDisorder;
	}

	public void setPostTraumaticStressDisorder(Boolean postTraumaticStressDisorder) {
		PostTraumaticStressDisorder = postTraumaticStressDisorder;
	}

	public Boolean getSchizophrenia() {
		return Schizophrenia;
	}

	public void setSchizophrenia(Boolean schizophrenia) {
		Schizophrenia = schizophrenia;
	}

	public Boolean getEatingDisorders() {
		return EatingDisorders;
	}

	public void setEatingDisorders(Boolean eatingDisorders) {
		EatingDisorders = eatingDisorders;
	}

	public Boolean getAnxiety() {
		return Anxiety;
	}

	public void setAnxiety(Boolean anxiety) {
		Anxiety = anxiety;
	}

	public Boolean getObesessiveCompulsiveDisorder() {
		return ObesessiveCompulsiveDisorder;
	}

	public void setObesessiveCompulsiveDisorder(Boolean obesessiveCompulsiveDisorder) {
		ObesessiveCompulsiveDisorder = obesessiveCompulsiveDisorder;
	}

	public Boolean getManicDepression() {
		return ManicDepression;
	}

	public void setManicDepression(Boolean manicDepression) {
		ManicDepression = manicDepression;
	}

	public Boolean getPhobia() {
		return Phobia;
	}

	public void setPhobia(Boolean phobia) {
		Phobia = phobia;
	}

	public Boolean getAutisticSpectrumDisorder() {
		return AutisticSpectrumDisorder;
	}

	public void setAutisticSpectrumDisorder(Boolean autisticSpectrumDisorder) {
		AutisticSpectrumDisorder = autisticSpectrumDisorder;
	}

	public Boolean getDepression() {
		return Depression;
	}

	public void setDepression(Boolean depression) {
		Depression = depression;
	}
	
}
