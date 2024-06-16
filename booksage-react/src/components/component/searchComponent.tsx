import {Input} from "@/components/ui/input";
import {Button} from "@/components/ui/button";
import {SearchIcon} from "@/components/ui/icon";
import React, {useState} from "react";
import HistoryBar from "@/components/component/historyBar";

interface searchComponentProps {
    query: string,
    setQuery: React.Dispatch<React.SetStateAction<string>>,
    handleSearch: () => void,
    handleKeyDown: (e: React.KeyboardEvent) => void
    history: string[],
    setHistory: React.Dispatch<React.SetStateAction<string[]>>,


}

export function SearchComponent({query, setQuery, handleSearch, handleKeyDown, history, setHistory}: searchComponentProps) {

    return (<div className="flex items-center gap-2">
        <HistoryBar handleSearch={handleSearch} history={history} setHistory={setHistory} setQuery={setQuery} />
        <Input
            className="rounded-md border border-gray-200 border-gray-300 px-3 py-2 focus:outline-none focus:ring-2 focus:ring-gray-500 dark:border-gray-800"
            placeholder="Search..."
            type="search"
            value={query}
            onChange={(e) => setQuery(e.target.value)}
            onKeyDown={handleKeyDown}
        />
        <Button size="icon" variant="ghost" onClick={handleSearch}>
            <SearchIcon className="w-5 h-5"/>
            <span className="sr-only">Search</span>
        </Button>
    </div>);
}