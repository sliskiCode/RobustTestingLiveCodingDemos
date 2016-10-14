package io.github.sliskicode.robusttestinglivecodingdemos

import spock.lang.Specification
import spock.lang.Unroll

/**
 * 7, 8
 */
class MainActivityPresenterSpockTest extends Specification {

    def viewMock = Mock(MainActivityMVP.View)
    def tested = new MainActivityPresenter(viewMock)

    def "should not show any message for null tag"() {
        when:
        tested.present(_ as boolean, null)

        then:
        0 * viewMock.showMessage(_)
    }

    @Unroll
    def "should show '#message' on view"() {
        when:
        tested.present(isRecreated, tag)

        then:
        1 * viewMock.showMessage(message)

        where:
        isRecreated | tag   | message
        false       | "tag" | "First creation"
        true        | "tag" | "Recreation"
    }
}
