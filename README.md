# Booksage (북세이지)
<img width="1710" alt="image" src="https://github.com/user-attachments/assets/1f550cff-1838-4cfc-bcf8-a3d68ce9543f" />
Booksage는 국민대학교 도서관과 주요 온라인 서점의 도서 정보를 한 눈에 비교할 수 있는 웹 서비스입니다.

###### (위 스크린샷은 25.01.27. 인터파크도서가 운영 중단된 상태임을 알립니다.)


## 주요 기능

- **통합 도서 검색**: 성곡도서관, 교보문고, 인터파크 도서의 도서 정보를 동시에 검색
- **실시간 가격 비교**: 온라인 서점별 도서 가격 비교 기능
- **도서관 소장 여부 확인**: 성곡도서관의 도서 소장 여부 실시간 확인
- **최근 검색어**: 최근 검색한 5개의 키워드 저장 및 빠른 재검색 지원

## 기술 스택

### Frontend
- Next.js 14
- TypeScript
- Tailwind CSS

### Backend
- Spring Boot 3.2
- Java 21
- JPA
- H2 Database
- Selenium & JSoup (웹 스크래핑)

## 시스템 아키텍처

```
Frontend (Next.js) <-> Backend (Spring Boot) <-> External Services
                                                - 성곡도서관
                                                - 교보문고
                                                - 인터파크
```

## 설치 및 실행 방법

### Frontend (booksage-react)
```bash
cd booksage-react
npm install
npm run dev
```

### Backend (booksage-spring)
```bash
cd booksage-spring
./gradlew bootRun
```

## API 엔드포인트

### 도서 검색 API
- `GET /api/bookstore/{store}` - 서점별 베스트셀러 목록 조회
- `GET /api/bookstore/{store}/search?query={keyword}` - 도서 검색
- `GET /api/bookstore/library/request-book` - 도서관 도서 신청 페이지 리다이렉트

### 회원 관련 API
- `POST /api/member/register` - 회원가입
- `POST /api/member/bookmarks` - 북마크 추가
- `DELETE /api/member/bookmarks/{bookmarkId}` - 북마크 삭제
- `GET /api/member/bookmarks` - 북마크 목록 조회

## 주요 특징

1. **실시간 데이터**: 웹 스크래핑을 통한 실시간 도서 정보 제공
2. **검색 기록 관리**: 최근 검색어 저장 및 관리 기능
3. **다크 모드**: 라이트 모드/다크 모드 전환 가능, 로컬에 기존 상태 저장
