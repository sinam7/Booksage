"use client"
import {Logo} from "@/components/component/logo";
import {SearchComponent} from "@/components/component/searchComponent";
import {BookColumn} from "@/components/component/bookColumn";
import React, {useState} from "react";

export function Component() {
    const [query, setQuery] = useState<string>('');
    const [searchTerm, setSearchTerm] = useState<string | null>(null);

    const handleSearch = () => {
        setSearchTerm(query.trim());
        setQuery(query.trim());
    };

    const handleKeyDown = (e: React.KeyboardEvent) => {
        if (e.key === 'Enter') {
            handleSearch();
        }
    };

    return (
        <div>
            <header className="flex items-center justify-between h-16 px-6 border-b">
                <Logo/>
                <SearchComponent
                    query={query}
                    setQuery={setQuery}
                    handleSearch={handleSearch}
                    handleKeyDown={handleKeyDown}
                />
            </header>
            <div className="container mx-auto py-12 ml-4">
                <div className="grid grid-cols-3 gap-8">
                    <BookColumn name={"library"} query={searchTerm} displayName={"성곡도서관"}/>
                    <BookColumn name={"kyobo"} query={searchTerm} displayName={"교보문고"}/>
                    <BookColumn name={"interpark"} query={searchTerm} displayName={"인터파크 도서"}/>
                </div>
            </div>
        </div>
    )
}

