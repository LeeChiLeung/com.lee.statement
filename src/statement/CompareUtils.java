package statement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CompareUtils {
	private static double count = 0d;
	private static int index = 0;
	public void inputMap(Map<String, List<String>> map, String key) {

		List<String> finance = map.get("finance.rtf");// 财务数据
		System.out.println("财务车牌数量:" + finance.size());
		List<String> history = map.get("history.rtf");
		System.out.println("历史车牌数量:" + history.size());

		switch (key) {
		case "finance-->history":
			Set<String> temp = compare(finance, history);
			System.out.println("财务数据对比历史数据");
			System.out.println("历史数据缺少车牌:" + Arrays.toString(temp.toArray()));
			break;
		case "history-->finance":
			Set<String>  temps = compare(history, finance);
			System.out.println("历史数据对比财务数据");
			System.out.println("财务数据缺少车牌:" + Arrays.toString(temps.toArray()));
			break;

		default:
			break;
		}

	}

	private Set<String> compare(List<String> src, List<String> goal) {
		Set<String> temp = new HashSet<>();
		for (String string : src) {
			if (!goal.contains(string)) {
				temp.add(string);
			}
		}
		return temp;

	}

	private void licensePlateCompare(List<String> finance, List<String> history, String key) {
		switch (key) {
		case "f-->h":
			Set<String> temp = compare(finance, history);
			System.out.println("财务数据对比历史数据");
			System.out.println("历史数据缺少车牌:" + Arrays.toString(temp.toArray()));
			break;
		case "h-->f":
			Set<String> temps = compare(history, finance);
			System.out.println("历史数据对比财务数据");
			System.out.println("财务数据缺少车牌:" + Arrays.toString(temps.toArray()));
			break;

		default:
			break;
		}
	}

	public void compareExcel(Map<String, List<ExcelResolveModel>> map, String key) {
		index = 0;
		count =0d;
		List<ExcelResolveModel> financeList = map.get("财务数据");
		List<ExcelResolveModel> historyList = map.get("历史保单");
		System.out.println("财务数据共:" + financeList.size() + "条");
		System.out.println("历史数据共:" + historyList.size() + "条");
		Double financeInsurancePrice = financeList.stream().map(ExcelResolveModel::getInsurancePrice).reduce(0d,
				(a, b) -> a + b);
		Double historyInsurancePrice = historyList.stream().map(ExcelResolveModel::getInsurancePrice).reduce(0d,
				(a, b) -> a + b);
		Double financeCompanyFee = financeList.stream().map(ExcelResolveModel::getCompanyFee).reduce(0d,
				(a, b) -> a + b);
		Double historyCompanyFee = historyList.stream().map(ExcelResolveModel::getCompanyFee).reduce(0d,
				(a, b) -> a + b);
		Double financeSubsidyFee = financeList.stream().map(ExcelResolveModel::getSubsidy).reduce(0d, (a, b) -> a + b);
		Double historySubsidyFee = historyList.stream().map(ExcelResolveModel::getSubsidy).reduce(0d, (a, b) -> a + b);
		Double financeMechanismSubsidyFee = financeList.stream().map(ExcelResolveModel::getMechanismSubsidyFee)
				.reduce(0d, (a, b) -> a + b);
		Double historyMechanismSubsidyFee = historyList.stream().map(ExcelResolveModel::getMechanismSubsidyFee)
				.reduce(0d, (a, b) -> a + b);
		System.out.println("财务数据总保费:   " + formatResult(financeInsurancePrice) + "元");
		System.out.println("历史总保费:  " +formatResult( historyInsurancePrice) + "元");
		System.out.println("两者相差" + formatResult(financeInsurancePrice - historyInsurancePrice));
		System.out.println();

		System.out.println("财务数据总手续费:   " + formatResult(financeCompanyFee) + "元");
		System.out.println("历史总手续费:  " + (historyCompanyFee) + "元");
		System.out.println("两者相差" + formatResult(financeCompanyFee - historyCompanyFee));
		System.out.println();
		System.out.println("财务数据总补贴费:   " + formatResult(financeSubsidyFee) + "元");
		System.out.println("历史总补贴费:  " + formatResult(historySubsidyFee) + "元");
		System.out.println("两者相差" + formatResult(financeSubsidyFee - historySubsidyFee));
		System.out.println();

		System.out.println("财务数据总机构/跟单手续费:   " + formatResult(financeMechanismSubsidyFee )+ "元");
		System.out.println("历史总机构/跟单手续费:  " +formatResult( historyMechanismSubsidyFee )+ "元");
		System.out.println("两者相差" + formatResult(financeMechanismSubsidyFee - historyMechanismSubsidyFee));
		System.out.println();

		// 财务车牌列表
		List<String> financelicensePlateList = financeList.stream().map(ExcelResolveModel::getLicensePlate)
				.collect(Collectors.toList());
		List<String> historylicensePlateList = historyList.stream().map(ExcelResolveModel::getLicensePlate)
				.collect(Collectors.toList());
        
		
		
		//licensePlateCompare(financelicensePlateList, historylicensePlateList, key);
		//System.out.println();
		// 差额合计
		
		System.out.println(key+"\r\n");
		
		if (key.equals("f-->h")||key.equals("h-->f")) {
			
			licensePlateCompare(financelicensePlateList, historylicensePlateList, key);
			return;
			
		}
		
		
		
		
		// 补贴费 差额查找 双循环 根据车牌 保险公司 所属部门
		for (int i = 0; i < financeList.size(); i++) {
			for (int v = 0; v < historyList.size(); v++) {

				if (financeList.get(i).getLicensePlate().equals(historyList.get(v).getLicensePlate())
						&& financeList.get(i).getInsurancePrice().equals(historyList.get(v).getInsurancePrice())&& financeList.get(i).getInsuranceType().equals(historyList.get(v).getInsuranceType())) {
					
					this.calculation(financeList.get(i), historyList.get(v), key);
//						System.out.println("车牌:" + financeList.get(i).getLicensePlate() + ",机构手续费差额:" + (financeList.get(i).getMechanismSubsidyFee() - historyList.get(v).getMechanismSubsidyFee()));
//						System.out.println("车牌:" + financeList.get(i).getLicensePlate() + ",手续费差额:" + (financeList.get(i).getCompanyFee() - historyList.get(v).getCompanyFee()));
//						System.out.println(financeList.get(i));
//						System.out.println(historyList.get(v));

				}
			}
		}
		System.out.println("补贴费差额合计:" + count + " 合计 :" + index + "条");
	}

	private void calculation(ExcelResolveModel finance, ExcelResolveModel history, String key
			) {
		switch (key) {
		case "补贴费对比":
			double f = finance.getSubsidy() - history.getSubsidy();
			BigDecimal bg = new BigDecimal(f);
			double margin = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
			if (margin != 0d) {
				System.out.println("车牌:" + finance.getLicensePlate()+"\n险种类型: "+finance.getInsuranceType()+ "\n补贴费:f: " + finance.getSubsidy()
						+ " h:" + history.getSubsidy());
                System.out.println("补贴率f:"+finance.getSubsidyRate()
						+ " h:" + history.getSubsidyRate());
                System.out.println("补贴费率差额:" + new BigDecimal((finance.getSubsidyRate()- history.getSubsidyRate())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
				System.out.println("补贴费差额:" + margin+"\r\n");
				count += f;
				index++;
			}
			break;
		case "跟单手续费/机构手续费对比":
			Double d = finance.getMechanismSubsidyFee() - history.getMechanismSubsidyFee();
			BigDecimal dg = new BigDecimal(d);
			double MechanismSubsidyFee = dg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
			if (MechanismSubsidyFee != 0d) {
                System.out.println("车牌:" + finance.getLicensePlate() +"\n险种类型: "+finance.getInsuranceType()+"\n财务跟单手续费f :"+finance.getMechanismSubsidyFee()+"\n历史跟单手续费h: "+history.getMechanismSubsidyFee());
				System.out.println( "机构手续费/跟单手续费差额" + MechanismSubsidyFee);
				System.out.println("\r\n");
				count += d;
				index++;

			}
			break;
		case "手续费/总公司手续费对比":
			double companyFee = finance.getCompanyFee() - history.getCompanyFee();
			BigDecimal cg = new BigDecimal(companyFee);
			double companyFees = cg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
			if (companyFees != 0d) {
                System.out.println("车牌:" + finance.getLicensePlate() +"\n险种类型: "+finance.getInsuranceType()+"\n财务手续费f :"+finance.getCompanyFee()+"\n历史手续费h: "+history.getCompanyFee());
				System.out.println("手续费/总公司手续费差额" + companyFees);
				System.out.println("\r\n");
				count += companyFee;
				index++;

			}
			break;
		default:
			break;
		}
	}
	
	private Double formatResult(Double value) {
		return new BigDecimal(value).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue(); 
	}
}
