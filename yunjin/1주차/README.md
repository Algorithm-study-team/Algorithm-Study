- 2022/04/18

프린터 (프로그래머스 : [코딩테스트 연습 - 프린터 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/42587))

유형 : 코딩테스트 연습 > 스택/큐 Lv2

문제 : 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성

풀이 : class를 사용해서 해결

1. list for문 돌며 max값 구해서 푼것 : 시간초과 -> 다른방법 찾기
2. for문 이나 while루프보다 stream()함수를 사용하면 편리하다.
3. location위치를 따로 관리하려면 복잡하기 때문에 class를 사용해서 해결하면 좋다.



- 2022/04/19

완주하지 못한 선수 (프로그래머스 : [코딩테스트 연습 - 완주하지 못한 선수 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/42576))

유형 : 코딩테스트 연습 > 해시 Lv1

문제 : 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성

풀이 :

1) Array.sort를 이용해서 해결

2) 해시맵을 이용해서 해결

2-1)  *Map.getOrDefault*(key, Default-value) => 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.

2-2) 값을 찾을 때는 map.keySet() or Map.Entry 사용



- 2022/04/20

전화번호 목록 (프로그래머스 : [코딩테스트 연습 - 전화번호 목록 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/42577))

유형 : 코딩테스트 연습 > 해시 Lv2

문제 : 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성

풀이 :

1) Array.sort를 이용해서 해결

2) 해시맵을 이용해서 해결

2-1)  해시맵을 돌면서 접두어가 있는지 판단 : map.containsKey(phone_book[i].substring(0,j))



- 2022/04/21

위장 (프로그래머스 :[코딩테스트 연습 - 위장 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/42578)https://programmers.co.kr/learn/courses/30/lessons/42577))

유형 : 코딩테스트 연습 > 해시 Lv2

문제 : 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성

풀이 : 해시맵을 이용해서 해결



- 2022/04/22

신규 아이디 추천 (프로그래머스 :[코딩테스트 연습 - 신규 아이디 추천 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/72410))

유형 : 코딩테스트 연습 > 2021 kakao blind recruitment

문제 : 신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성

풀이 : 문자열을 변경 + 정규표현식을 이용하여 풀이
