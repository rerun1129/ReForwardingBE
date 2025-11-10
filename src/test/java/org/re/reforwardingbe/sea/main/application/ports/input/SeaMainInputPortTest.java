package org.re.reforwardingbe.sea.main.application.ports.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeaMainInputPortTest {
    /*
    * TODO [0] 픽스쳐
    * 1. 초기 데이터 세팅은 테스트 클래스의 @BeforeEach에서 진행한다.
    * 2. 픽스쳐는 5개 이상의 데이터를 리포지토리에 기본적으로 담는다.
    * 3. B/L 엔티티 픽스쳐 내부에는 B/L 메인과 1대1 대응하는 VO와 1대N으로 대응하는 VO가 있다.
    * */


    /*
    * TODO [1] 저장
    * 1. B/L 메인이 저장된다.
    *   1) 저장 여부는 해당 메서드의 호출 여부로 확인한다.
    *   2) 저장 후 리포지토리에 데이터가 픽스쳐 + 1개 만큼 존재하는지 확인한다.
    * 2. B/L 내부의 Container가 저장된다.
    *   1) 저장 여부는 해당 메서드의 호출 여부로 확인한다.
    *   2) 저장 후 리포지토리에 데이터가 픽스쳐 내부 Container 데이터 + 1개 만큼 존재하는지 확인한다.
    * 3. B/L 내부의 HSCode가 저장된다.
    *   1) 저장 여부는 해당 메서드의 호출 여부로 확인한다.
    *   2) 저장 후 리포지토리에 데이터가 픽스쳐 내부 HSCode 데이터 + 1개 만큼 존재하는지 확인한다.
    * 4. B/L 내부의 Manifest가 저장된다.
    *   1) 저장 여부는 해당 메서드의 호출 여부로 확인한다.
    *   2) 저장 후 리포지토리에 데이터가 픽스쳐 내부 Manifest 데이터 + 1개 만큼 존재하는지 확인한다.
    * */
    /*
     * TODO [2] 조회
     * 1. 저장된 B/L 메인이 조회된다.
     *   1) B/L 메인의 존재 여부는 해당 B/L 메인의 ID로 리포지토리를 검색하여 확인한다.(모든 엔티티의 구조를 탐색할 필요가 없음)
     * 2. 저장된 Container가 조회된다.
     *   1) Container의 존재 여부는 해당 B/L 메인의 ID + Container의 서브 ID로 리포지토리를 검색하여 확인한다.
     * 3. 저장된 HSCode가 조회된다.
     *   1) HSCode의 존재 여부는 해당 B/L 메인의 ID + HSCode의 서브 ID로 리포지토리를 검색하여 확인한다.
     * 4. 저장된 Manifest가 조회된다.
     *   1) Manifest의 존재 여부는 해당 B/L 메인의 ID + Manifest의 서브 ID로 리포지토리를 검색하여 확인한다.
     */
    /*
     * TODO [3] 삭제
     * 1. 저장된 B/L 메인이 삭제 된다.
     *   1) B/L 메인의 삭제 여부는 리포지토리에 해당 ID가 존재하는지 여부이다.
     *   2) 삭제 후 리포지토리에 픽스쳐 개 만큼의 데이터가 존재하는지 확인한다.
     * 2. 저장된 Container가 삭제 된다.
     *   1) B/L 메인의 삭제 여부는 리포지토리에 해당 ID가 존재하는지 여부이다.
     *   2) 삭제 후 리포지토리에 픽스쳐 개 만큼의 데이터가 존재하는지 확인한다.
     * 3. 저장된 HSCode가 삭제 된다.
     *   1) B/L 메인의 삭제 여부는 리포지토리에 해당 ID가 존재하는지 여부이다.
     *   2) 삭제 후 리포지토리에 픽스쳐 개 만큼의 데이터가 존재하는지 확인한다.
     * 4. 저장된 Manifest가 삭제 된다.
     *   1) B/L 메인의 삭제 여부는 리포지토리에 해당 ID가 존재하는지 여부이다.
     *   2) 삭제 후 리포지토리에 픽스쳐 개 만큼의 데이터가 존재하는지 확인한다.
     * */

    @Test
    @DisplayName("B/L 메인이 저장된다")
    public void testSaveBlMain(){
        //given

        //when

        //then
    }

    @Test
    @DisplayName("B/L 내부의 Container가 저장된다")
    public void testSaveBlContainer(){
        //given

        //when

        //then
    }

    @Test
    @DisplayName("B/L 내부의 HSCode가 저장된다")
    public void testSaveBlHSCode(){
        //given

        //when

        //then
    }

    @Test
    @DisplayName("B/L 내부의 Manifest가 저장된다")
    public void testSaveBlManifest(){
        //given

        //when

        //then
    }
}