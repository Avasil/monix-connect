/*
 * Copyright (c) 2020-2020 by The Monix Connect Project Developers.
 * See the project homepage at: https://connect.monix.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package monix.connect.mongodb

import com.mongodb.client.model.{
  CountOptions,
  DeleteOptions,
  FindOneAndDeleteOptions,
  FindOneAndReplaceOptions,
  FindOneAndUpdateOptions,
  InsertManyOptions,
  InsertOneOptions,
  ReplaceOptions,
  UpdateOptions
}
import monix.execution.internal.InternalApi

package object domain {

  // default options
  @InternalApi private[mongodb] val DefaultDeleteOptions = new DeleteOptions()
  @InternalApi private[mongodb] val DefaultCountOptions = new CountOptions()
  @InternalApi private[mongodb] val DefaultFindOneAndDeleteOptions = new FindOneAndDeleteOptions()
  @InternalApi private[mongodb] val DefaultFindOneAndReplaceOptions = new FindOneAndReplaceOptions()
  @InternalApi private[mongodb] val DefaultFindOneAndUpdateOptions = new FindOneAndUpdateOptions()
  @InternalApi private[mongodb] val DefaultInsertOneOptions = new InsertOneOptions()
  @InternalApi private[mongodb] val DefaultInsertManyOptions = new InsertManyOptions()
  @InternalApi private[mongodb] val DefaultUpdateOptions = new UpdateOptions()
  @InternalApi private[mongodb] val DefaultReplaceOptions = new ReplaceOptions()

  // results
  @InternalApi private[mongodb] case class DeleteResult(deleteCount: Long, wasAcknowledged: Boolean)
  @InternalApi private[mongodb] case class InsertOneResult(insertedId: Option[String], wasAcknowledged: Boolean)
  @InternalApi private[mongodb] case class InsertManyResult(insertedIds: Set[String], wasAcknowledged: Boolean)
  @InternalApi private[mongodb] case class UpdateResult(
    matchedCount: Long,
    modifiedCount: Long,
    wasAcknowledged: Boolean)

  // default results
  @InternalApi private[mongodb] val DefaultDeleteResult = DeleteResult(deleteCount = 0L, wasAcknowledged = false)
  @InternalApi private[mongodb] val DefaultInsertOneResult =
    InsertOneResult(insertedId = Option.empty[String], wasAcknowledged = false)
  @InternalApi private[mongodb] val DefaultInsertManyResult =
    InsertManyResult(insertedIds = Set.empty[String], wasAcknowledged = false)
  @InternalApi private[mongodb] val DefaultUpdateResult =
    UpdateResult(matchedCount = 0L, modifiedCount = 0L, wasAcknowledged = false)
}
