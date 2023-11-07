package com.triforce.malacprodavac.domain.model

data class OffsetPaginationMeta(val nzm:Number)
data class PaginationResponse<T>(val data: List<T>, val meta: OffsetPaginationMeta)
