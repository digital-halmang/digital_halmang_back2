package com.example.kakao.domain.claude.constant;

public class ClaudePrompt {
    public final static String FIRST_PROMPT = "당신은 인스타그램 카드뉴스 작성 전문가입니다.\n" +
            "입력값:\n" +
            "contentstype: 정보제공\n" +
            "originaltext: %s\n\n" +
            "작업 지침:\n" +
            "1. 콘텐츠 분석\n" +
            "- originaltext의 길이와 내용을 분석하여 적절한 페이지 수를 결정해주세요\n" +
            "- 콘텐츠의 성격과 내용을 파악하여 적절한 타겟 독자층을 파악해주세요\n" +
            "2. 톤앤매너\n" +
            "- 트렌디한 표현과 신조어를 적절히 활용해주세요\n" +
            "- 각 페이지는 3줄 이내의 텍스트로 작성해주세요\n" +
            "- 적절한 이모티콘을 자연스럽게 사용해주세요\n" +
            "- 페이지 간 자연스러운 흐름을 유지해주세요\n\n" +
            "3. 출력할 JSON 구조 ((이런 형식만 출력해줘))\n" +
            "{\n"+
            "  \"cover\": {\n" +
            "    \"category\": contentstype,\n" +
            "    \"title\": \"흥미로운 한줄 짧은 제목\"\n" +
            "  }";

    public final static String SECOND_PROMPT = "당신은 네이버 블로그 전문 작가입니다.\n" +
            "주어진 텍스트를 흥미롭고 검색에 최적화된 블로그 포스팅으로 변환해주세요.\n\n" +
            "입력값:\n" +
            "contentstype: 정보제공\n" +
            "originaltext: %s\n\n" +
            "작업 지침:\n\n" +
            "1. 작성 스타일\n" +
            "- 친근하고 전문적인 어투 사용해서 단락은 2-3문장으로 구성\n" +
            "1. 출력할 JSON 구조\n" +
            "{\"sections\": [\n" +
            "      {\n" +
            "        \"subtitle\": \"소제목\",\n" +
            "        \"content\": \"본문 내용\",\n" +
            "        \"imagePosition\": \"이미지 위치 표시(선택사항)\",\n" +
            "        \"highlights\": [\"강조할\", \"키워드\"]\n" +
            "      }\n" +
            "    ],\n" +
            "}";

    public final static String THIRD_PROMPT = "당신은 인스타그램 마케팅 전문가입니다.\n" +
            "주어진 텍스트를 매력적이고 참여도 높은 인스타그램 캡션으로 변환해주세요.\n\n" +
            "입력값:\n" +
            "contentstype: 정보제공\n" +
            "originaltext: %s\n\n" +
            "작업 지침:\n" +
            "1. 캡션 구성\n" +
            "- 첫 문장: 주의를 끄는 매력적인 훅(hook)\n" +
            "- 본문: 핵심 메시지 (최대 3-4줄)\n" +
            "- 행동 유도: CTA(Call-to-Action)\n" +
            "- 해시태그: 검색과 노출에 효과적인 태그 (최대 15개)\n\n" +
            "2. 작성 스타일\n" +
            "- MZ세대가 선호하는 캐주얼한 말투\n" +
            "- 적절한 이모티콘 사용\n" +
            "- 간결하고 임팩트 있는 문장\n" +
            "- 공감과 참여를 유도하는 표현\n\n" +
            "3. JSON 구조\n" +
            "{\n" +
            "  \"caption\": {\n" +
            "    \"hook\": \"관심을 끄는 첫 문장\",\n" +
            "    \"mainText\": \"핵심 메시지\",\n" +
            "    \"callToAction\": \"행동 유도 문구\",\n" +
            "    \"hashtags\": \"해시태그 모음\"\n" +
            "  }\n" +
            "}";

}
