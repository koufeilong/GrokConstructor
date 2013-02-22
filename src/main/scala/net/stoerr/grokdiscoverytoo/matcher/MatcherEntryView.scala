package net.stoerr.grokdiscoverytoo.matcher

import net.stoerr.grokdiscoverytoo.webframe.WebView
import javax.servlet.http.HttpServletRequest
import net.stoerr.grokdiscoverytoo.GrokPatternLibrary

/**
 * @author <a href="http://www.stoerr.net/">Hans-Peter Stoerr</a>
 * @since 17.02.13
 */
class MatcherEntryView(val request: HttpServletRequest) extends WebView {
  def title: String = "Test grok patterns"

  val form = MatcherForm(request)

  def body: AnyRef = <body>
    <h1>Test grok patterns</h1>
    <form action="/web/matching" method="post">
      <table>
        <tr>
          <td>Please enter some loglines and then press
            <input type="submit" value="Go!"/>
          </td>
        </tr>
        <tr>
          <td>
            {form.loglines.label("Some log lines you want to match. Choose diversity.")}
          </td>
        </tr>
        <tr>
          <td>
            {form.loglines.inputTextArea(10, 180)}
          </td>
        </tr>
        <tr>
          <td>Grok Patterns from
            <a href="http://logstash.net/">logstash</a>
            v.1.19 :
            {form.groklibs.checkboxes(GrokPatternLibrary.grokpatternKeys)}
            and some
            {form.extralibs.checkboxes(GrokPatternLibrary.extrapatternKeys)}
            from me
          </td>
        </tr>
        <tr>
          <td>
            {form.pattern.label("The pattern that should match all of them")}
          </td>
        </tr>
        <tr>
          <td>
            {form.pattern.inputText(180)}
          </td>
        </tr>
      </table>
    </form>
  </body>
}
