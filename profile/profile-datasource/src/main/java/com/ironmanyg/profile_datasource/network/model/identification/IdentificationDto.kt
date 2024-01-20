package com.ironmanyg.profile_datasource.network.model.identification

import com.ironmanyg.profile_domain.user.identification.IDType
import com.ironmanyg.profile_domain.user.identification.Identification
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Data Transfer Object (DTO) representing the identification details of a user in the blood donation system. This class aids in conveying user identification data from the network layer to the application layer.
 *
 * @property idType A string representation of the type of identification document. It should match one of the constants defined in [IDType].
 * @property idNumber The unique number associated with the identification document.
 * @property communityId A list of community IDs associated with the user. It can be null if not provided.
 */
@Serializable
data class IdentificationDto(
    @SerialName("id_type")
    val idType: String,
    @SerialName("id_number")
    val idNumber: String,
    @SerialName("community_id")
    val communityId: List<String>?
)

/**
 * Extension function to convert IdentificationDto to the Identification domain model object. This is instrumental in maintaining a separation of concerns between the network and domain layers, promoting a clean code architecture.
 *
 * @return An Identification domain model with the attributes mapped from the IdentificationDto object.
 */
fun IdentificationDto.toIdentification() = Identification(
    idType = IDType.fromName(idType),
    idNumber = idNumber,
    communityId = communityId
)
