package statement;

public class ExcelResolveModel {
/**
 * 成本=跟单手续费 
 * 收入=手续费+补贴费
 */
	private String excelFileName;
	
	private String licensePlate;
	
	private String companyName;
	
	private Double insurancePrice;//保费
	
	private String department;//所属部门
	
    private Double mechanismSubsidyFee;//机构手续费 即跟单手续费 支出
	
    //收入
	private Double companyFee;//公司手续费  
	private Double subsidy;//补贴
	
	private String insuranceType;//险种类别 车险交强险 车险商业险
	
	private Double subsidyRate;//补贴率
	
	
	public String getExcelFileName() {
		return excelFileName;
	}
	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}
	
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
    public void setInsurancePrice(Double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}
    public Double getInsurancePrice() {
		return insurancePrice;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Double getMechanismSubsidyFee() {
		return mechanismSubsidyFee;
	}
	public void setMechanismSubsidyFee(Double mechanismSubsidyFee) {
		this.mechanismSubsidyFee = mechanismSubsidyFee;
	}
	public Double getCompanyFee() {
		return companyFee;
	}
	public void setCompanyFee(Double companyFee) {
		this.companyFee = companyFee;
	}
	public Double getSubsidy() {
		return subsidy;
	}
	public void setSubsidy(Double subsidy) {
		this.subsidy = subsidy;
	}
	
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	
	public Double getSubsidyRate() {
		return subsidyRate;
	}
	public void setSubsidyRate(Double subsidyRate) {
		this.subsidyRate = subsidyRate;
	}
	@Override
	public String toString() {
		return "ExcelResolveModel [excelFileName=" + excelFileName + ", licensePlate=" + licensePlate + ", companyName="
				+ companyName + ", insurancePrice=" + insurancePrice + ", department=" + department
				+ ", mechanismSubsidyFee=" + mechanismSubsidyFee + ", companyFee=" + companyFee + ", subsidy=" + subsidy
				+ ", insuranceType=" + insuranceType + ", subsidyRate=" + subsidyRate + "]";
	}
	
	
	
	
	
	
	
    
	
	
	
}
