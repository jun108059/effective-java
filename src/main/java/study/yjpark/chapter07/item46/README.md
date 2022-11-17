# 아이템 46. 스트림에서는 부작용 없는 함수를 사용하라

- 스트림 파이프라인 프로그래밍의 핵심은 side-effect 없는 함수 객체
- 스트림뿐 아니라 스트림 관련 객체에 건네지는 모든 함수 객체가 side-effect가 없어야 함
- 종단 연산 중 forEach는 스트림이 수행한 계산 결과를 보고할 때만 사용
- 계산 자체에는 이용하지 말자. 스트림을 올바로 사용하려면 Collector 활용이 중요
- 가장 중요한 Collector 팩터리는 toList, toSet, toMap, groupingBy, joining