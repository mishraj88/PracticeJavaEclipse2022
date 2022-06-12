package com.practice.streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SortHashMapOnValues {

	public static void main(String[] args) {
		Map<String, Integer> map = new LinkedHashMap<>();

		map.put("a", 3);
		map.put("b", 1);
		map.put("c", 9);
		//map.put("d", null);
		//map.put(null, null);

		System.out.println("Before Sorting: map "+map);

		
		LinkedHashMap<String, Integer> sortedMap = map.entrySet().stream()
				.sorted((e1,e2) -> {
					if(e1.getValue() != null && e2.getValue() != null)
						return e1.getValue() - e2.getValue();
					else {
						if(e1.getValue() == null) return 0 - e2.getValue();
						return e1.getValue() -0;
					}
				}).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k1,k2) -> k1, LinkedHashMap:: new));

		System.out.println("After sorting : sorted map: "+sortedMap);


		Map<String, Integer> map2 = new LinkedHashMap<>();

		map2.put("a", 3);
		map2.put("b", 1);
		map2.put("c", 9);
		//map2.put("d", null);
		//map2.put(null, null);	
		
		System.out.println("b4 map with null key and null values: "+map2);
		Map<String, Integer> collect = map2.entrySet().stream()
				.sorted(Map.Entry.comparingByValue()).collect(LinkedHashMap::new,(m,e) -> m.put(e.getKey(), e.getValue()), LinkedHashMap::putAll);
		
		System.out.println("after sorting map with null key and null values: "+collect);
		
		
		map2.put("d", null);
		map2.put(null, null);	
		
		
		Map<String, Integer> collect_new = map2.entrySet().stream()
				.sorted((e1, e2) -> {
					Optional<String> e1_Keyoptional = Optional.ofNullable(e1.getKey());
					Optional<Integer> e1_valOptional = Optional.ofNullable(e1.getValue());
					Optional<String> e2_KeyOptional = Optional.ofNullable(e2.getKey());
					Optional<Integer> e2_ValOptional = Optional.ofNullable(e2.getValue());
					
					if(e1_valOptional.isPresent() && e2_ValOptional.isPresent()) {
						return e1_valOptional.get().compareTo(e2_ValOptional.get());
					}else {
						if(e1_valOptional.isEmpty() && e2_ValOptional.isPresent()) return e2_ValOptional.get();
						if(e1_valOptional.isEmpty() && e2_ValOptional.isEmpty()) return 0;
						return e1_valOptional.get();
					}
				}).
				collect(LinkedHashMap::new,(m,e) -> m.put(e.getKey(), e.getValue()), LinkedHashMap::putAll);
		
		System.out.println("collect_new : "+collect_new);


	}

}
