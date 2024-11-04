# 환경 변수 설정 (기본값: dev)
PROFILE=${SPRING_PROFILES_ACTIVE:-dev}

# JVM 옵션 설정
JVM_OPTS="-Xmx512m -Xms256m"

# 빌드 실행
echo "Building application..."
./gradlew clean build

# 빌드 성공 여부 확인
if [ $? -eq 0 ]; then
    # build/libs 디렉토리에서 jar 파일 찾기 (*plain.jar 제외)
    JAR_FILE=$(find build/libs -name "*.jar" ! -name "*plain.jar" -type f)

    if [ -n "$JAR_FILE" ]; then
        echo "Starting application using $JAR_FILE"
        echo "Active profile: $PROFILE"

        # JVM 옵션과 프로파일 설정으로 실행
        java $JVM_OPTS \
             -Dspring.profiles.active=$PROFILE \
             -jar "$JAR_FILE"
    else
        echo "No JAR file found in build/libs directory"
        exit 1
    fi
else
    echo "Build failed"
    exit 1
fi
