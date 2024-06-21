# 베이스 이미지 설정
FROM openjdk:21

CMD ["./gradlew", "clean", "build"]

VOLUME /app/storefile
# 빌드 시 변수 설정
ARG JAR_FILE=./build/libs/*.jar

# JAR 파일을 Docker 이미지에 복사
COPY ${JAR_FILE} web-app.jar

# 프로파일을 위한 환경 변수 설정
ARG PROFILE=prod
ENV PROFILE=${PROFILE}
ENV SPRING_MAIL_HOST=smtp.naver.com
ENV SPRING_MAIL_USERNAME=gkswlgns7653@naver.com
ENV SPRING_MAIL_PASSWORD=7U519SSEK8PN

# 컨테이너 시작 명령어 설정
ENTRYPOINT ["java", "-jar", "/web-app.jar", "-Duser.timezone=Asia/Seoul"]
