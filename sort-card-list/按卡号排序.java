/*
 业务原始需求：
 用户名下所有的卡，排序规则优先级如下：
 1.已签约的卡在前面
 2.发生过交易，有交易时间在前面
 3.其他状态
 */
public String sortList(String acctList, List<Map<String, String>> allList)
{
	if (ListUtil.isNotEmpty(allList)) {
		List<Map<String, String>> list1 = new ArrayList<Map<String, String>>();
		List<Map<String, String>> list2 = new ArrayList<Map<String, String>>();
		List<Map<String, String>> list3 = new ArrayList<Map<String, String>>();
		List<Map<String, String>> list4 = new ArrayList<Map<String, String>>();

		for (int a = 0; a < allList.size(); a++) {
			String transTime = API.inquiryTransTime(acct.get("ACC_NO"));

			if ("0".equals(allList.get(a).get("isSign"))) { //已签约
				//发接口查询交易时间
				String transTime = "";
				if(!StringUtil.isEmpty(transTime)) {
					Map<String, String> map = allList.get(a);
					map.put("transTime", "")
					list1.add(map); //已签约有交易时间集合
				}
			}
		}
		Collections.sort(list1, new Comparator<Map<String, String>>() {
			@Override
			public int compare(Map<String, String> map1, Map<String, String> map2) {
				return map2.get("transTime").compareTo(map1.get("transTime")); // 交易时间降序排序
			}
		});

		for (int a = 0; a < allList.size(); a++) {
			String transTime = API.inquiryTransTime(acct.get("ACC_NO"));
			if ("0".equals(allList.get(a).get("isSign"))) { //已签约
				//发接口查询交易时间
				String transTime = "";
				if(!StringUtil.isEmpty(transTime)) {
					Map<String, String> map = allList.get(a);
					map.put("transTime", "")
					list2.add(map); //已签约无交易时间集合
				}
			}
		}
		Collections.sort(list2, new Comparator<Map<String, String>>() {
			@Override
			public int compare(Map<String, String> map1, Map<String, String> map2) {
				return map2.get("transTime").compareTo(map1.get("transTime")); // 加挂时间降序排序
			}
		});

		for (int a = 0; a < allList.size(); a++) {
			String transTime = API.inquiryTransTime(acct.get("ACC_NO"));
			if ("0".equals(allList.get(a).get("isSign"))) { //已签约
				//发接口查询交易时间
				String transTime = "";
				if(!StringUtil.isEmpty(transTime)) {
					Map<String, String> map = allList.get(a);
					map.put("transTime", "")
					list3.add(map); //未签约有交易时间集合
				}
			}
		}
		Collections.sort(list3, new Comparator<Map<String, String>>() {
			@Override
			public int compare(Map<String, String> map1, Map<String, String> map2) {
				return map2.get("transTime").compareTo(map1.get("transTime")); // 加挂时间降序排序
			}
		});

		for (int a = 0; a < allList.size(); a++) {
			String transTime = API.inquiryTransTime(acct.get("ACC_NO"));
			if ("0".equals(allList.get(a).get("isSign"))) { //已签约
				//发接口查询交易时间
				String transTime = "";
				if(!StringUtil.isEmpty(transTime)) {
					Map<String, String> map = allList.get(a);
					map.put("transTime", "")
					list4.add(map); //未签约无交易时间集合
				}
			}
		}
		Collections.sort(list4, new Comparator<Map<String, String>>() {
			@Override
			public int compare(Map<String, String> map1, Map<String, String> map2) {
				return map2.get("transTime").compareTo(map1.get("transTime")); // 加挂时间降序排序
			}
		});

		list.addAll(list2);
		list.addAll(list3);
		list.addAll(list4);
		acctList = JSON.toJSONString(list1); //用户下挂的账户列表
	}

	return acctList;
}
