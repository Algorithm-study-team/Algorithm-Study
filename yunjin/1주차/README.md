- 2022/04/18

프린터 (프로그래머스 : [코딩테스트 연습 - 프린터 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/42587?language=java#))

유형 : 코딩테스트 연습 > 스택/큐 Lv2

문제 : 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성

풀이 : class를 사용해서 해결

1. list for문 돌며 max값 구해서 푼것 : 시간초과 -> 다른방법 찾기
2. for문 이나 while루프보다 stream()함수를 사용하면 편리하다.
3. location위치를 따로 관리하려면 복잡하기 때문에 class를 사용해서 해결하면 좋다.
