package it.auties.whatsapp.protobuf.sync;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Accessors(fluent = true)
public class SyncdPatch {
  @JsonProperty("8")
  @JsonPropertyDescription("uint32")
  private int deviceIndex;

  @JsonProperty("7")
  @JsonPropertyDescription("ExitCode")
  private ExitCode exitCode;

  @JsonProperty("6")
  @JsonPropertyDescription("KeyId")
  private KeyId keyId;

  @JsonProperty("5")
  @JsonPropertyDescription("bytes")
  private byte[] patchMac;

  @JsonProperty("4")
  @JsonPropertyDescription("bytes")
  private byte[] snapshotMac;

  @JsonProperty("3")
  @JsonPropertyDescription("ExternalBlobReference")
  private ExternalBlobReference externalMutations;

  @JsonProperty("2")
  @JsonPropertyDescription("SyncdMutation")
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<SyncdMutation> mutations;

  @JsonProperty("1")
  @JsonPropertyDescription("SyncdVersion")
  private SyncdVersion version;
}