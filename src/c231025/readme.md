# VPN

- Virtual Private Network
- IP 우회해서 다른데로 바꾼다? 보안도 늘린다?
- 우리 컴퓨터 -> VPN 서버 -> 다른 웹페이지 요청 -> VPN이 받고 -> 우리 컴퓨터

# Proxy
- 반대로 다른 곳에서 우리한테 보내준 걸 다른 웹페이지, 내부적으로 다른 port로 요청을 보내 처리하는 것
- "http://localhost" -> naver 출력

# AWS
- 컴퓨터를 몇대 둘까? 3대? 1대? 프로젝트 개수만큼?
- 프로젝트가 크지 않다, 무겁지 않다 -> 1대
- 1대의 컴퓨터 안에서 프로젝트를 몇개 배포할수 있을까? => 몇개든 성능만 된다면
- Java:80(http), Node.js:8081, React:3000, GoLang:8082 => https:443
- 443/java => Java,
  443/node => Node.js,
  443/react => React,
  443/go => GoLang
- 외부 <-> apache:443/java <-> java:80 << proxy
| reverser proxy
- Cross Origin Resources Sharing 

# EC2 -> Elastic Cloud Computing -> 인스턴스
- 유동적인 클라우드 컴퓨팅
- 유동적인 가상의 클라우드 서버
- 가상 << 볼수없다. 모니터 X 마우스 X 키보드 X
- 요청을 보내서 포트와 연결이되면 우리한테 출력을 해준다.

# S3 -> Simple Storage Service -> 버켓
- 저장소

# Route 53 -> 호스팅과 도메인 관리   	