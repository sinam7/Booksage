"use client"
import {SearchComponent} from "@/components/component/searchComponent";
import {BookColumn} from "@/components/component/bookColumn";
import React, {useState} from "react";

export function Component() {
    const [query, setQuery] = useState<string>('');
    const [searchTerm, setSearchTerm] = useState<string | null>(null);
    const [history, setHistory] = useState<string[]>([]);

    // const handleSearch = () => {
    //     setSearchTerm(query.trim());
    //     setQuery(query.trim());
    // };

    const handleSearch = () => {
        const trimmedQuery = query.trim();
        setSearchTerm(trimmedQuery);
        setQuery(trimmedQuery);
        if (trimmedQuery) {
            setHistory((prevHistory) => {
                const newHistory = [...prevHistory];
                if (newHistory.includes(trimmedQuery)) {
                    // Move the existing query to the end
                    newHistory.splice(newHistory.indexOf(trimmedQuery), 1);
                } else if (newHistory.length >= 5) {
                    // Remove the oldest item if history size exceeds 5
                    newHistory.shift();
                }
                newHistory.push(trimmedQuery);
                return newHistory;
            });
        }
    };

    const handleKeyDown = (e: React.KeyboardEvent) => {
        if (e.key === 'Enter') {
            handleSearch();
        }
    };

    return (
        <div>
            <header className="flex items-center justify-between h-16 px-6 border-b">
                <div className="flex items-center justify-center">
                    {/* eslint-disable-next-line @next/next/no-img-element */}
                    <img src="https://github.com/sinam7/Booksage/blob/master/booksage-react/logo.png?raw=true"
                          width={48} height={48} alt="Booksage"/>
                    Booksage
                </div>
                <SearchComponent
                    query={query}
                    setQuery={setQuery}
                    handleSearch={handleSearch}
                    handleKeyDown={handleKeyDown}
                    history={history}
                    setHistory={setHistory}
                />
            </header>
            <div className="container mx-auto py-2 m-4">
                <div className="grid grid-cols-3 gap-8">
                    <BookColumn name={"library"} query={searchTerm} displayName={"성곡도서관"}/>
                    <BookColumn name={"kyobo"} query={searchTerm} displayName={"교보문고"}/>
                    <BookColumn name={"interpark"} query={searchTerm} displayName={"인터파크 도서"}/>
                </div>
            </div>
        </div>
    )
}

