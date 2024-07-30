package com.ll.sapp;

import com.ll.sapp.answer.Answer;
import com.ll.sapp.answer.AnswerRepository;
import com.ll.sapp.question.Question;
import com.ll.sapp.question.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class SappApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    //테스트 환경에서는 트랜젝션이 달린 테스트케이스는 기본적으로 자동롤백 됨,
    //@Rollback(false) 이렇게 하면 트랜젝션 성공 후 자동롤백이 되지 않음
    @Test
    void testJpa() {
        // 질묻 데이터 저장하기 1st
//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1);  // 첫번째 질문 저장
//
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);  // 두번째 질문 저장

        // 질문 데이터 조회하기 2nd
//        List<Question> all = this.questionRepository.findAll();
//        assertEquals(2, all.size());
//
//        Question q = all.get(0); // List는 0,1,2 ... 가능
//        assertEquals("sbb가 무엇인가요?", q.getSubject());

        // id값을 이용해 데이터 조회 3rd
//        Optional<Question> oq = this.questionRepository.findById(1);
//        if(oq.isPresent()) {
//            Question q = oq.get();  // Optional은 공백(1개)만 가능 #-> 1개만 찾는 기능이다보니 데이터가 있냐없냐 판단
//            assertEquals("sbb가 무엇인가요?", q.getSubject());
//        }
        // subject값으로 데이터 조회 4th
//        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?"); #같은 질문이 2개 이상이면 에러 발생
//        assertEquals(1, q.getId());

        // subject와 content를 함꼐 조회 5nd
//        Question q = this.questionRepository.findBySubjectAndContent(
//                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//        assertEquals(1, q.getId());

        // subject열에서 특정 문자열 포함 데이터 조회 6th
//        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//        Question q = qList.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());

        // 질문 데이터 수정하기 7th #첫 실행은 에러가 나는게 맞음. 두번째 시도는 안되는게 맞고 적용이 됨
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        q.setSubject("수정된 제목");
//        this.questionRepository.save(q);

        // 질문 데이터 삭제하기 8th
//        assertEquals(2, this.questionRepository.count());
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        this.questionRepository.delete(q);
//        assertEquals(1, this.questionRepository.count());

        // 답변 데이터 저장하기 9th
//        Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다.");
//        a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//        a.setCreateDate(LocalDateTime.now());
//        this.answerRepository.save(a);

        // 답변 데이터 조회하기 10th
//        Optional<Answer> oa = this.answerRepository.findById(1);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(2, a.getQuestion().getId());

        // 질문에 해당하는 답변 모두 조회 11th <- 가능한 이유 : DB테이블에는 나타나지 않지만 Question클래스에 OneToMany 어노테이션을 만들어놔기 때문
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size()); // 에러이유 : 명시적으로 트랜젝션을 활성화해줘야함
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    }
}