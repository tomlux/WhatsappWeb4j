package it.auties.whatsapp.protobuf.message.business;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.auties.whatsapp.protobuf.info.ContextInfo;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Accessors(fluent = true)
public class ButtonsResponseMessage {
  @JsonProperty(value = "2")
  private String selectedDisplayText;

  @JsonProperty(value = "4")
  private ButtonsResponseMessageType type;

  @JsonProperty(value = "3")
  private ContextInfo contextInfo;

  @JsonProperty(value = "1")
  private String selectedButtonId;

  @Accessors(fluent = true)
  public enum ButtonsResponseMessageType {
    UNKNOWN(0),
    DISPLAY_TEXT(1);

    private final @Getter int index;

    ButtonsResponseMessageType(int index) {
      this.index = index;
    }

    @JsonCreator
    public static ButtonsResponseMessageType forIndex(int index) {
      return Arrays.stream(values())
          .filter(entry -> entry.index() == index)
          .findFirst()
          .orElse(null);
    }
  }

  public Response responseCase() {
    if (selectedDisplayText != null) return Response.SELECTED_DISPLAY_TEXT;
    return Response.UNKNOWN;
  }

  @Accessors(fluent = true)
  public enum Response {
    UNKNOWN(0),
    SELECTED_DISPLAY_TEXT(2);

    private final @Getter int index;

    Response(int index) {
      this.index = index;
    }

    @JsonCreator
    public static Response forIndex(int index) {
      return Arrays.stream(values())
          .filter(entry -> entry.index() == index)
          .findFirst()
          .orElse(Response.UNKNOWN);
    }
  }
}