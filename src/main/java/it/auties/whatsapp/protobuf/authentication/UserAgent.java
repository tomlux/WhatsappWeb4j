package it.auties.whatsapp.protobuf.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Accessors(fluent = true)
public class UserAgent {
  @JsonProperty(value = "13")
  @JsonPropertyDescription("string")
  private String deviceBoard;

  @JsonProperty(value = "12")
  @JsonPropertyDescription("string")
  private String localeCountryIso31661Alpha2;

  @JsonProperty(value = "11")
  @JsonPropertyDescription("string")
  private String localeLanguageIso6391;

  @JsonProperty(value = "10")
  @JsonPropertyDescription("UserAgentReleaseChannel")
  private UserAgentReleaseChannel releaseChannel;

  @JsonProperty(value = "9")
  @JsonPropertyDescription("string")
  private String phoneId;

  @JsonProperty(value = "8")
  @JsonPropertyDescription("string")
  private String osBuildNumber;

  @JsonProperty(value = "7")
  @JsonPropertyDescription("string")
  private String device;

  @JsonProperty(value = "6")
  @JsonPropertyDescription("string")
  private String manufacturer;

  @JsonProperty(value = "5")
  @JsonPropertyDescription("string")
  private String osVersion;

  @JsonProperty(value = "4")
  @JsonPropertyDescription("string")
  private String mnc;

  @JsonProperty(value = "3")
  @JsonPropertyDescription("string")
  private String mcc;

  @JsonProperty(value = "2")
  @JsonPropertyDescription("AppVersion")
  private Version appVersion;

  @JsonProperty(value = "1")
  @JsonPropertyDescription("UserAgentPlatform")
  private UserAgentPlatform platform;

  @Accessors(fluent = true)
  public enum UserAgentPlatform {
    ANDROID(0),
    IOS(1),
    WINDOWS_PHONE(2),
    BLACKBERRY(3),
    BLACKBERRYX(4),
    S40(5),
    S60(6),
    PYTHON_CLIENT(7),
    TIZEN(8),
    ENTERPRISE(9),
    SMB_ANDROID(10),
    KAIOS(11),
    SMB_IOS(12),
    WINDOWS(13),
    WEB(14),
    PORTAL(15),
    GREEN_ANDROID(16),
    GREEN_IPHONE(17),
    BLUE_ANDROID(18),
    BLUE_IPHONE(19),
    FBLITE_ANDROID(20),
    MLITE_ANDROID(21),
    IGLITE_ANDROID(22),
    PAGE(23),
    MACOS(24),
    VR(25);

    private final @Getter int index;

    UserAgentPlatform(int index) {
      this.index = index;
    }

    @JsonCreator
    public static UserAgentPlatform forIndex(int index) {
      return Arrays.stream(values())
          .filter(entry -> entry.index() == index)
          .findFirst()
          .orElse(null);
    }
  }

  @Accessors(fluent = true)
  public enum UserAgentReleaseChannel {
    RELEASE(0),
    BETA(1),
    ALPHA(2),
    DEBUG(3);

    private final @Getter int index;

    UserAgentReleaseChannel(int index) {
      this.index = index;
    }

    @JsonCreator
    public static UserAgentReleaseChannel forIndex(int index) {
      return Arrays.stream(values())
          .filter(entry -> entry.index() == index)
          .findFirst()
          .orElse(null);
    }
  }
}