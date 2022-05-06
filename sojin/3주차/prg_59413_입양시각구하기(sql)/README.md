<h2>문제이름:Programmers 입양시각 구하기(Lv4)  </h2>

https://programmers.co.kr/learn/courses/30/lessons/59413

<h2>설계</h2>

- SQL

  - sql에서 좀 어려운 문제였다.
  - @Hour=-1;으로 변수 선언을 하고, @Hour을 1씩 늘려가면서 @Hour이 <23이 될때까지 구하는 것이다. (큰 select문)
  - 작은 select 문에서는 HOUR(datetime)으로 시간을 구해서 큰 select문의 @Hour이랑 같은 count을 센다.



<h2>코드</h2>

```
SET @Hour=-1;
select (@Hour:=@Hour+1) AS HOUR, (
    select COUNT(HOUR(datetime)) from animal_outs where HOUR(datetime)=@Hour
) AS COUNT from animal_outs
where @Hour<23;


```

