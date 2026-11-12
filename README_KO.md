# NCT AI — 휴대폰으로 APK 만들기

이 프로젝트는 **APK 빌드용 시작 프로젝트**입니다. Termux에서 Android SDK를 직접 컴파일하지 않고 GitHub Actions의 무료 빌드 환경을 이용합니다.

## 1) GitHub 저장소 만들기
1. 휴대폰 브라우저에서 https://github.com/new 열기
2. 저장소 이름을 `nct-ai-android`로 입력
3. Public 또는 Private 선택 후 Create repository

## 2) 파일 올리기
1. 이 ZIP을 휴대폰에 압축 해제
2. 새 저장소 페이지에서 `Add file` → `Upload files`
3. 압축 해제한 폴더 안의 **파일과 폴더 전체**를 업로드 (바깥 폴더 자체가 아니라 그 안의 내용)
4. `Commit changes` 누르기

## 3) APK 받기
1. 저장소의 `Actions` 탭 열기
2. `Build NCT AI APK` 작업이 실행되는지 확인
3. 완료된 작업 클릭 → 아래 `Artifacts`에서 `NCT-AI-debug-APK` 다운로드
4. ZIP 압축을 풀고 `app-debug.apk`를 눌러 설치

## 중요
- 지금 버전은 앱 화면과 모델 선택이 있는 **초기 APK 빌드 프로젝트**입니다.
- 실제 AI 답변은 아직 연결되지 않았습니다. 실제 사용하려면 별도 서버 배포와 서버 주소 설정이 필요합니다.
- API 키를 앱 코드에 직접 넣지 마세요. 서버의 비밀 환경변수로 보관해야 합니다.
