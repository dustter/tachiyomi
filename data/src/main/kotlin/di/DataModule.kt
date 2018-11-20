/*
 * Copyright (C) 2018 The Tachiyomi Open Source Project
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package tachiyomi.data.di

import com.pushtorefresh.storio3.sqlite.StorIOSQLite
import tachiyomi.data.catalog.prefs.CatalogPreferences
import tachiyomi.data.catalog.prefs.CatalogPreferencesProvider
import tachiyomi.data.category.CategoryRepositoryImpl
import tachiyomi.data.chapter.ChapterRepositoryImpl
import tachiyomi.data.extension.ExtensionManager
import tachiyomi.data.extension.prefs.ExtensionPreferences
import tachiyomi.data.extension.prefs.ExtensionPreferencesProvider
import tachiyomi.data.library.LibraryRepositoryImpl
import tachiyomi.data.library.prefs.LibraryPreferences
import tachiyomi.data.library.prefs.LibraryPreferencesProvider
import tachiyomi.data.manga.MangaRepositoryImpl
import tachiyomi.data.source.SourceManagerProvider
import tachiyomi.domain.category.repository.CategoryRepository
import tachiyomi.domain.chapter.repository.ChapterRepository
import tachiyomi.domain.library.repository.LibraryRepository
import tachiyomi.domain.manga.repository.MangaRepository
import tachiyomi.domain.source.SourceManager
import toothpick.config.Module

object DataModule : Module() {

  init {
    bind(StorIOSQLite::class.java).toProvider(StorIOProvider::class.java)
    bind(MangaRepository::class.java).to(MangaRepositoryImpl::class.java).singletonInScope()
    bind(ChapterRepository::class.java).to(ChapterRepositoryImpl::class.java).singletonInScope()
    bind(LibraryRepository::class.java).to(LibraryRepositoryImpl::class.java).singletonInScope()
    bind(CategoryRepository::class.java).to(CategoryRepositoryImpl::class.java).singletonInScope()
    bind(SourceManager::class.java).toProvider(SourceManagerProvider::class.java)
    bind(CatalogPreferences::class.java).toProvider(CatalogPreferencesProvider::class.java)
    bind(LibraryPreferences::class.java).toProvider(LibraryPreferencesProvider::class.java)
    bind(ExtensionManager::class.java).singletonInScope()
    bind(ExtensionPreferences::class.java).toProvider(ExtensionPreferencesProvider::class.java)
  }

}