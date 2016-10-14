package io.github.sliskicode.robusttestinglivecodingdemos;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * 1, 2, 3, 4, 5
 */
@RunWith(Enclosed.class)
public class MainActivityPresenterJUnitTest {

    public static class IndividualTests {

        private static MainActivityMVP.View mainActivityView;

        private MainActivityPresenter mainActivityPresenter;

        @Test
        public void testShouldNotShowAnyMessageForNullTag() throws Exception {
            // GIVEN
            mainActivityView = mock(MainActivityMVP.View.class);
            mainActivityPresenter = new MainActivityPresenter(mainActivityView);

            // WHEN
            mainActivityPresenter.present(true, null);

            // THEN
            verify(mainActivityView, never()).showMessage(anyString());
        }
    }

    @RunWith(Parameterized.class)
    public static class ParameterizedTests {

        private static MainActivityMVP.View mainActivityView;
        private MainActivityPresenter mainActivityPresenter;

        @Parameters(name = "should show {2} on viewMock")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {true, "tag", "Recreation"},
                    {false, "tag", "First creation"}
            });
        }

        private boolean isRecreated;
        private String tag;
        private String message;

        public ParameterizedTests(boolean isRecreated, String tag, String message) {
            this.isRecreated = isRecreated;
            this.tag = tag;
            this.message = message;
        }

        @Test
        public void present_ShouldShowMessageOnView() {
            // GIVEN
            mainActivityView = mock(MainActivityMVP.View.class);
            mainActivityPresenter = new MainActivityPresenter(mainActivityView);

            // WHEN
            mainActivityPresenter.present(isRecreated, tag);

            // THEN
            verify(mainActivityView).showMessage(message);
        }
    }
}
