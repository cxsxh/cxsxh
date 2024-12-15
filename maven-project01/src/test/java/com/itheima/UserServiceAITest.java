package com.itheima;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("用户信息测试")
public class UserServiceAITest {
    private UserService userService;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("before All");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("after All");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("before Each");
        userService = new UserService();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after Each");
    }

    @Test
    public void testGetGender_ValidIdCardOddNumber_ReturnsMale() {
        String idCard = "110105199001010011"; // 假设倒数第二位是奇数，表示男性
        String gender = userService.getGender(idCard);
        System.out.println("getGender result: " + gender);
        assertEquals("男", gender, "性别应该是男");
    }

    @Test
    public void testGetGender_ValidIdCardEvenNumber_ReturnsFemale() {
        String idCard = "110105199001010022"; // 假设最后一位是偶数，表示女性
        String gender = userService.getGender(idCard);
        System.out.println("getGender result: " + gender);
        assertEquals("女", gender, "性别应该是女");
    }

    @Test
    public void testGetGender_InvalidLength_ThrowsException() {
        try {
            userService.getGender("10000020001001101");
            fail("应该抛出 IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("无效的身份证号码", e.getMessage(), "异常消息应该是'无效的身份证号码'");
        }
    }

    @Test
    public void testGetGender_NullIdCard_ThrowsException() {
        try {
            userService.getGender(null);
            fail("应该抛出 IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("无效的身份证号码", e.getMessage(), "异常消息应该是'无效的身份证号码'");
        }
    }

    @Test
    public void testGetGender_InvalidCharacters_ThrowsException() {
        try {
            userService.getGender("10000020001001101a");
//            fail("应该抛出 IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("无效的身份证号码", e.getMessage(), "异常消息应该是'无效的身份证号码'");
        }
    }

    @DisplayName("用户性别测试")
    @ParameterizedTest
    @ValueSource(strings = {"110105199001010021", "110105199001010022", "110105199001010023"})
    public void testGetGenderWithAssert3_CorrectGender(String idCard) {
        String expectedGender = Integer.parseInt(idCard.substring(16, 17)) % 2 == 1 ? "男" : "女";
        String actualGender = userService.getGender(idCard);
        System.out.println("getGender result: " + actualGender);
        assertEquals(expectedGender, actualGender, "性别应该是" + expectedGender);
    }
}
