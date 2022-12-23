# 미션 1 (12.20 ~ 12.27)

## 진행 순서
- Day1(12.20) : 프로젝트 빌드, Swagger, Docker 세팅, CI/CD 구성
- Day2(12.21) : 회원가입, 로그인 
- Day3~4 (12.22~23) : 게시글 조회, 등록, 수정, 삭제

## 기능 구현 상세
### 회원가입

### 로그인

### 게시판 CRUD
1) [get] 전체 포스트 조회 (현재 DB에 있는 모든 데이터 조회)
2) [post] 포스트 등록 (입력: title, body) > (반환: resultCode, result)
   - title, body 콘텐츠 db에 save()
3) [put] 포스트 수정 (입력: title, body) > (반환: resultCode, result)
   - title id db에 있는지 찾기. findById()
   - title id가 db에 없으면 POST_NOT_FOUND 에러
   - title이 db에 있으면 get.entity(title, body)
   - body에 해당하는 값으로 다시 db에 save()
   - 결과값 반환
4) [delete] 포스트 삭제하기 (반환: resultCode, result)
   - deleteById()